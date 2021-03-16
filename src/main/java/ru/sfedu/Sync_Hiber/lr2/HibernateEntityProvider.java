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

import java.io.IOException;
import java.util.List;

public class HibernateEntityProvider {
    private Logger log = LogManager.getLogger();
    private Session session;

    private void initSession() throws IOException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    private void close() {
        session.close();
    }

    public Admin createAdmin(Admin admin) throws IOException {
        initSession();
        Transaction tx = session.beginTransaction();
        admin.setId((Long) session.save(admin));
        tx.commit();
        close();
        return admin;
    }

    public List<Admin> getAdmins() throws IOException {
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

    public Admin getAdminById(long id) throws IOException {
        initSession();
        try {
            Admin admin = session.get(Admin.class, id);
            close();
            if (admin == null) {
                admin = new Admin();
                log.error("Not found.");
            }
            return admin;
        }
        catch(Exception e) {
            close();
            return new Admin();
        }
    }

    public Boolean deleteAdmin(long id) throws IOException {
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

    public Admin updateAdmin(Admin admin) throws IOException {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(admin);
        tr.commit();
        close();
        return admin;
    }
}
