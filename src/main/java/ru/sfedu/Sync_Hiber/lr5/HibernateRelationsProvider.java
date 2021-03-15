package ru.sfedu.Sync_Hiber.lr5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import ru.sfedu.Sync_Hiber.Constants;
import ru.sfedu.Sync_Hiber.lr5.models.*;
import ru.sfedu.Sync_Hiber.lr5.utils.HibernateUtil;

import java.math.BigInteger;
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

    public Guest createGuest(Guest guest) {
        initSession();
        Transaction tx = session.beginTransaction();
        guest.setId((Long) session.save(guest));
        tx.commit();
        log.debug(guest);
        close();
        return guest;
    }

    public List<Guest> getGuests () {
        String query = String.format(Constants.GET_QUERY, Guest.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Guest> guestList = session.createQuery(query).list();
        tx.commit();
        log.debug(guestList);
        close();
        return guestList;
    }

    public Guest getGuestById(long id) {
        initSession();
        try {
            Guest guest = session.get(Guest.class, id);
            log.debug(guest);
            close();
            return guest;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Guest();
        }
    }

    public Boolean deleteGuest(long id) {
        initSession();
        Guest guest = new Guest();
        guest.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(guest);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Guest updateGuest (Guest guest) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(guest);
        tr.commit();
        close();
        return guest;
    }

    public List<Manager> getManagers () {
        String query = String.format(Constants.GET_QUERY, Manager.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Manager> managerList = session.createQuery(query).list();
        tx.commit();
        log.debug(managerList);
        close();
        return managerList;
    }


    public Manager createManager(Manager manager) {
        initSession();
        Transaction tx = session.beginTransaction();
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
        Transaction tx = session.beginTransaction();
        List<Speaker> speakerList = session.createQuery(query).list();
        tx.commit();
        log.debug(speakerList);
        close();
        return speakerList;
    }


    public Speaker createSpeaker(Speaker speaker) {
        initSession();
        Transaction tx = session.beginTransaction();
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
        Transaction tx = session.beginTransaction();
        List<Channel> channelList = session.createQuery(query).list();
        tx.commit();
        log.debug(channelList);
        close();
        return channelList;
    }


    public Channel createChannel(Channel channel) {
        channel.getSpeakers().stream().forEach(this::createSpeaker);
        initSession();
        Transaction tx = session.beginTransaction();
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
        Transaction tx = session.beginTransaction();
        List<Zone> zoneList = session.createQuery(query).list();
        tx.commit();
        log.debug(zoneList);
        close();
        return zoneList;
    }


    public Zone createZone(Zone zone) {
        zone.getChannelList().stream().forEach(this::createChannel);
        zone.getGuests().stream().forEach(this::createGuest);
        createManager(zone.getManager());
        initSession();
        Transaction tx = session.beginTransaction();
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

    public BigInteger getZoneCountNative() {
        initSession();
        String query = String.format(Constants.GET_COUNT, Constants.ZONE);
        BigInteger count = (BigInteger) session.createSQLQuery(query).list().get(0);
        log.debug(count);
        close();
        return count;
    }

    public Long getZoneCountHQL() {
        initSession();
        String query = String.format(Constants.GET_COUNT, Constants.ZONE);
        Long count = (Long) session.createQuery(query).list().get(0);
        log.debug(count);
        close();
        return count;
    }

    public Long getZoneCountCriteria() {
        initSession();
        Criteria cr = session.createCriteria(Zone.class);
        cr.setProjection(Projections.count("id"));
        Long count = (Long) cr.list().get(0);
        log.debug(count);
        close();
        return count;
    }

    public long checkTimeHQL() {
        long timeStart = System.currentTimeMillis();
        getZoneCountHQL();
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long checkTimeNative() {
        long timeStart = System.currentTimeMillis();
        getZoneCountNative();
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long checkTimeCriteria() {
        long timeStart = System.currentTimeMillis();
        getZoneCountCriteria();
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

}
