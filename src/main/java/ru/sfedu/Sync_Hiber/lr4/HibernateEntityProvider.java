package ru.sfedu.Sync_Hiber.lr4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.Sync_Hiber.Constants;
import ru.sfedu.Sync_Hiber.lr4.models.Channel;
import ru.sfedu.Sync_Hiber.lr4.utils.HibernateUtil;

import java.util.List;

public class HibernateEntityProvider {
    private Logger log = LogManager.getLogger(HibernateEntityProvider.class);
    private Session session;

    private void initSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    private void close() {
        session.close();
    }

    public Channel createChannel(Channel channel) {
        initSession();
        Transaction tx = session.beginTransaction();
        channel.setId((Long) session.save(channel));
        tx.commit();
        return channel;
    }

    public List<Channel> getChannels() {
        initSession();
        try {
            String query = String.format(Constants.GET_QUERY, Channel.class.getSimpleName());
            Transaction tx = session.beginTransaction();
            List<Channel> channelList = session.createQuery(query).list();
            tx.commit();
            log.debug(channelList);
            close();
            return channelList;
        } catch (Exception e) {
            log.error(e);
            close();
            return null;
        }
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

    public Channel updateChannel(Channel channel) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(channel);
        tr.commit();
        close();
        return channel;
    }
}
