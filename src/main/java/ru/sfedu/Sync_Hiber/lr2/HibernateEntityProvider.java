package ru.sfedu.Sync_Hiber.lr2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.sfedu.Sync_Hiber.Constants;
import ru.sfedu.Sync_Hiber.lr2.models.Admin;
import ru.sfedu.Sync_Hiber.lr2.utils.HibernateUtil;

import java.util.List;

public class HibernateEntityProvider {
    private Logger log = LogManager.getLogger();
    private Session session;

    private void initSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    private void close() {
        session.close();
    }

    public Admin createAdmin(Admin admin) {
        initSession();
        Transaction tx = session.beginTransaction();
        admin.setId((Long) session.save(admin));
        tx.commit();
        close();
        return admin;
    }

    public List<Admin> getAdmins() {
        initSession();
        try {
            String query = String.format(Constants.GET_QUERY, Admin.class.getSimpleName());
            session.getTransaction().begin();
            List<Admin> adminList = session.createQuery(query).list();
            session.getTransaction().commit();
            close();
            return adminList;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    public Admin getAdminById(long id) {
        initSession();
        try {
            Admin admin = session.get(Admin.class, id);
            close();
            return admin;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Admin();
        }
    }

    public Boolean deleteAdmin(long id) {
        initSession();
        Admin admin = new Admin();
        admin.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(admin);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }

    public Admin updateAdmin(Admin admin) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(admin);
        tr.commit();
        close();
        return admin;
    }
}
