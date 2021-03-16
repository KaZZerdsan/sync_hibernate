package ru.sfedu.Sync_Hiber.lr4.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.Sync_Hiber.lr4.models.Channel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class HibernateUtil {

    private static final String CUSTOM_CONFIG_PATH = System.getProperty("hibernatePath");

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws IOException {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration;
            if (CUSTOM_CONFIG_PATH != null) {
                Properties props = new Properties();
                if (CUSTOM_CONFIG_PATH.contains("properties")) {
                    InputStream is = HibernateUtil.class.getResourceAsStream(CUSTOM_CONFIG_PATH);
                    props.load(is);
                    configuration = new Configuration();
                    configuration.addProperties(props);
                } else {
                    URL r1 = HibernateUtil.class.getResource(CUSTOM_CONFIG_PATH);
                    configuration = new Configuration().configure(r1);
                }
            } else {
                configuration = new Configuration();
            }
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(Channel.class);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;
    }
}