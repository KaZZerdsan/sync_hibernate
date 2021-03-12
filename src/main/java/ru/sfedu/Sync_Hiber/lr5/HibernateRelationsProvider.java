package ru.sfedu.Sync_Hiber.lr5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.Sync_Hiber.Constants;
import ru.sfedu.Sync_Hiber.lr5.models.*;
import ru.sfedu.Sync_Hiber.lr5.utils.HibernateUtil;

import java.util.List;

public class HibernateRelationsProvider {
    private Logger log = LogManager.getLogger(HibernateRelationsProvider.class);
    private Session session;

    private void initSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    private void close() {
        session.close();
    }

    public List<Admin> getAdmins () {
        String query = String.format(Constants.GET_QUERY, Admin.class.getSimpleName());
        initSession();
        Transaction tx = session.getTransaction();
        List<Admin> adminList = session.createQuery(query).list();
        tx.commit();
        close();
        return adminList;
    }


    public Admin createAdmin(Admin admin) {
        initSession();
        Transaction tx = session.getTransaction();
        admin.setId((long) session.save(admin));
        tx.commit();
        log.debug(admin);
        close();
        return admin;
    }


    public Admin getAdminById(long id) {
        initSession();
        try {
            Admin admin = session.get(Admin.class, id);
            log.debug(admin);
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


    public Admin updateAdmin (Admin admin) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(admin);
        tr.commit();
        close();
        return admin;
    }


    public List<Manager> getManagers () {
        String query = String.format(Constants.GET_QUERY, Manager.class.getSimpleName());
        initSession();
        Transaction tx = session.getTransaction();
        List<Manager> managerList = session.createQuery(query).list();
        tx.commit();
        close();
        return managerList;
    }


    public Manager createManager(Manager manager) {
        initSession();
        Transaction tx = session.getTransaction();
        manager.setId((long) session.save(manager));
        tx.commit();
        log.debug(manager);
        close();
        return manager;
    }


    public Manager getManagerById(long id) {
        initSession();
        try {
            Manager manager = session.get(Manager.class, id);
            log.debug(manager);
            close();
            return manager;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Manager();
        }
    }


    public Boolean deleteManager(long id) {
        initSession();
        Manager manager = new Manager();
        manager.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(manager);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Manager updateManager (Manager manager) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(manager);
        tr.commit();
        close();
        return manager;
    }


    public List<Speaker> getSpeakers () {
        String query = String.format(Constants.GET_QUERY, Speaker.class.getSimpleName());
        initSession();
        Transaction tx = session.getTransaction();
        List<Speaker> speakerList = session.createQuery(query).list();
        tx.commit();
        close();
        return speakerList;
    }


    public Speaker createSpeaker(Speaker speaker) {
        initSession();
        Transaction tx = session.getTransaction();
        speaker.setId((long) session.save(speaker));
        tx.commit();
        log.debug(speaker);
        close();
        return speaker;
    }


    public Speaker getSpeakerById(long id) {
        initSession();
        try {
            Speaker speaker = session.get(Speaker.class, id);
            log.debug(speaker);
            close();
            return speaker;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Speaker();
        }
    }


    public Boolean deleteSpeaker(long id) {
        initSession();
        Speaker speaker = new Speaker();
        speaker.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(speaker);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Speaker updateSpeaker (Speaker speaker) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(speaker);
        tr.commit();
        close();
        return speaker;
    }


    public List<Channel> getChannels () {
        String query = String.format(Constants.GET_QUERY, Channel.class.getSimpleName());
        initSession();
        Transaction tx = session.getTransaction();
        List<Channel> channelList = session.createQuery(query).list();
        tx.commit();
        close();
        return channelList;
    }


    public Channel createChannel(Channel channel) {
        initSession();
        Transaction tx = session.getTransaction();
        channel.setId((long) session.save(channel));
        tx.commit();
        log.debug(channel);
        close();
        return channel;
    }


    public Channel getChannelById(long id) {
        initSession();
        try {
            Channel channel = session.get(Channel.class, id);
            log.debug(channel);
            close();
            return channel;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Channel();
        }
    }


    public Boolean deleteChannel(long id) {
        initSession();
        Channel channel = new Channel();
        channel.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(channel);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Channel updateChannel (Channel channel) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(channel);
        tr.commit();
        close();
        return channel;
    }


    public List<Zone> getZones () {
        String query = String.format(Constants.GET_QUERY, Zone.class.getSimpleName());
        initSession();
        Transaction tx = session.getTransaction();
        List<Zone> zoneList = session.createQuery(query).list();
        tx.commit();
        close();
        return zoneList;
    }


    public Zone createZone(Zone zone) {
        initSession();
        Transaction tx = session.getTransaction();
        zone.setId((long) session.save(zone));
        tx.commit();
        log.debug(zone);
        close();
        return zone;
    }


    public Zone getZoneById(long id) {
        initSession();
        try {
            Zone zone = session.get(Zone.class, id);
            log.debug(zone);
            close();
            return zone;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Zone();
        }
    }


    public Boolean deleteZone(long id) {
        initSession();
        Zone zone = new Zone();
        zone.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(zone);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Zone updateZone (Zone zone) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(zone);
        tr.commit();
        close();
        return zone;
    }


    public List<Event> getEvents () {
        String query = String.format(Constants.GET_QUERY, Event.class.getSimpleName());
        initSession();
        Transaction tx = session.getTransaction();
        List<Event> eventList = session.createQuery(query).list();
        tx.commit();
        close();
        return eventList;
    }


    public Event createEvent(Event event) {
        initSession();
        Transaction tx = session.getTransaction();
        event.setId((long) session.save(event));
        tx.commit();
        log.debug(event);
        close();
        return event;
    }


    public Event getEventById(long id) {
        initSession();
        try {
            Event event = session.get(Event.class, id);
            log.debug(event);
            close();
            return event;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Event();
        }
    }


    public Boolean deleteEvent(long id) {
        initSession();
        Event event = new Event();
        event.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(event);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Event updateEvent (Event event) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(event);
        tr.commit();
        close();
        return event;
    }
}
