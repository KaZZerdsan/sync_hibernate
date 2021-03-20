package ru.sfedu.Sync_Hiber.lr5.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.Sync_Hiber.lr5.models.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {

    private static final String CUSTOM_CONFIG_PATH = System.getProperty("hibernatePath");

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws IOException {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration();
            if (CUSTOM_CONFIG_PATH != null) {
                Properties props = new Properties();
                if (CUSTOM_CONFIG_PATH.contains("properties")) {
                    File file = new File(CUSTOM_CONFIG_PATH);
                    InputStream in = new FileInputStream(file);
                    props.load(in);
                    configuration.addProperties(props);
                    System.out.println(props.toString());
                    in.close();
                } else {
                    configuration.configure(new File(CUSTOM_CONFIG_PATH));
                }
            }
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(Manager.class);
            metadataSources.addAnnotatedClass(Speaker.class);
            metadataSources.addAnnotatedClass(Channel.class);
            metadataSources.addAnnotatedClass(Zone.class);
            metadataSources.addAnnotatedClass(Guest.class);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;
    }
}