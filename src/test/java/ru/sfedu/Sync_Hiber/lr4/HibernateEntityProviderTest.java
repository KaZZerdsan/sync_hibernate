package ru.sfedu.Sync_Hiber.lr4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.Sync_Hiber.lr4.models.Channel;
import ru.sfedu.Sync_Hiber.lr4.models.Speaker;

import java.util.*;

public class HibernateEntityProviderTest {

    private Logger log = LogManager.getLogger(HibernateEntityProviderTest.class);
    private HibernateEntityProvider dp = new HibernateEntityProvider();

    @Test
    public void createChannel() {
        Map<String, String> features = new HashMap<String, String>();
        features.put("Drinks", "Yes");
        features.put("Food", "Yes");

        List<String> speakers = new ArrayList<String>();
        speakers.add("Vitaly");
        speakers.add("Denis");

        Set<String> langs = new HashSet<String>();
        langs.add("Russian");
        langs.add("English");

        Set<Speaker> speakerSet = new HashSet<Speaker>();
        Speaker speaker = new Speaker();
        speaker.setName("Vladimir");
        speakerSet.add(speaker);

        Channel channel = new Channel();
        channel.setName("Discovery");
        channel.setStatus(true);

        channel.setLanguage(langs);
        channel.setSpeakers(speakers);
        channel.setFeatures(features);
        channel.setSpeakerList(speakerSet);
        dp.createChannel(channel);
    }

    @Test
    public void getChannels() {
        List<Channel> channelList = dp.getChannels();
        log.info(channelList);
    }

    @Test
    public void getChannelById() {
        long id = 1;
        Channel channel = dp.getChannelById(id);
        log.info(channel);
    }

    @Test
    public void deleteChannel() {
        long id = 2;
        Boolean isDeleted = dp.deleteChannel(id);
        log.info(isDeleted);
    }

    @Test
    public void updateChannel() {
        long id = 3;
        Channel channel = dp.getChannelById(id);
        channel.setName("RenTV");
        channel = dp.updateChannel(channel);
        log.info(channel);
    }
}