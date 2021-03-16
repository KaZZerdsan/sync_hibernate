package ru.sfedu.Sync_Hiber.lr1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sfedu.Sync_Hiber.Constants;
import ru.sfedu.Sync_Hiber.lr1.utils.HibernateUtil;

import java.io.IOException;
import java.util.List;

public class HiberMetadataProvider {
    private Session session;
    private static final Logger log = LogManager.getLogger(HiberMetadataProvider.class);

    private void initSession() throws IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        this.session = sessionFactory.openSession();
    }

    private void close() {
        this.session.close();
    }

    public void getDatabaseSize() throws IOException {
        initSession();
        List<?> res = session.createSQLQuery(Constants.DB_SIZE_QUERY).list();
        log.info(String.format(Constants.LOG_DB_SIZE_IN_MB, res.get(0)));
        close();
    }

    public void getTables() throws IOException {
        initSession();
        List<?> res = session.createSQLQuery(Constants.ALL_TABLES_QUERY).getResultList();
        log.info(Constants.LOG_TABLES + res.toString());
        close();
    }

    public void getUsers() throws IOException {
        initSession();
        List<?> res = session.createSQLQuery(Constants.GET_USERS_QUERY).getResultList();
        log.info(Constants.LOG_USERS + res.toString());
        close();
    }

    public void getMySQLVersion() throws IOException {
        initSession();
        List<?> res = session.createSQLQuery(Constants.GET_VERSION_QUERY).getResultList();
        log.info(Constants.LOG_VERSION + res.get(0));
        close();
    }
}
