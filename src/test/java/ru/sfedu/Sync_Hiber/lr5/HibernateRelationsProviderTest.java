package ru.sfedu.Sync_Hiber.lr5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.Sync_Hiber.Constants;
import ru.sfedu.Sync_Hiber.lr5.models.*;
import ru.sfedu.Sync_Hiber.lr5.utils.GenerateEntity;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class HibernateRelationsProviderTest {

    private HibernateRelationsProvider dp = new HibernateRelationsProvider();
    private Logger log = LogManager.getLogger(HibernateRelationsProviderTest.class);

    @Test
    public void getManagers() throws IOException {
        List<Manager> managerList = dp.getManagers();
        log.info(managerList);
    }

    @Test
    public void createManager() throws IOException {
        Manager manager = new Manager();
        manager.setName("Mikhail");
        dp.createManager(manager);
        log.info(manager);
    }

    @Test
    public void getManagerById() throws IOException {
        Manager manager = dp.getManagerById(6);
        log.info(manager);
    }

    @Test
    public void deleteManager() throws IOException {
        List<Manager> managerList = dp.getManagers();
        long id = managerList.get(0).getId();
        Boolean hasDeleted = dp.deleteManager(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateManager() throws IOException {
        List<Manager> managerList = dp.getManagers();
        Manager manager = managerList.get(0);
        manager.setName(manager.getName() + "_new");
        dp.updateManager(manager);
        log.info(manager);
    }

    @Test
    public void getSpeakers() throws IOException {
        List<Speaker> speakerList = dp.getSpeakers();
        log.info(speakerList);
    }

    @Test
    public void createSpeaker() throws IOException {
        Speaker speaker = new Speaker();
        speaker.setName("Eugene");
        speaker = dp.createSpeaker(speaker);
        log.info(speaker);
    }

    @Test
    public void getSpeakerById() throws IOException {
        Speaker speaker = dp.getSpeakerById(1);
        log.info(speaker);
    }

    @Test
    public void deleteSpeaker() throws IOException {
        List<Speaker> speakerList = dp.getSpeakers();
        long id = speakerList.get(0).getId();
        Boolean hasDeleted = dp.deleteSpeaker(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateSpeaker() throws IOException {
        List<Speaker> speakerList = dp.getSpeakers();
        Speaker speaker = speakerList.get(0);
        speaker.setName(speaker.getName() + "_new");
        speaker = dp.updateSpeaker(speaker);
        log.info(speaker);
    }

    @Test
    public void getChannels() throws IOException {
        List<Channel> channelList = dp.getChannels();
        log.info(channelList);
    }

    @Test
    public void createChannel() throws IOException {
        List<Speaker> speakerList = GenerateEntity.generateSpeakers(5);
        Channel channel = new Channel();
        channel.setLanguage("Russian");
        channel.setStatus(false);
        channel.setName("Discovery");
        channel.setSpeakers(speakerList);
        channel = dp.createChannel(channel);
        log.info(channel);
    }

    @Test
    public void getChannelById() throws IOException {
        Channel channel = dp.getChannelById(2);
        log.info(channel);
    }

    @Test
    public void deleteChannel() throws IOException {
        List<Channel> channelList = dp.getChannels();
        long id = channelList.get(0).getId();
        Boolean hasDeleted = dp.deleteChannel(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateChannel() throws IOException {
        List<Channel> channelList = dp.getChannels();
        Channel channel = channelList.get(0);
        channel.setName(channel.getName() + "_new");
        channel = dp.updateChannel(channel);
        log.info(channel);
    }

    @Test
    public void getZones() throws IOException {
        List<Zone> zoneList = dp.getZones();
        log.info(zoneList);
    }

    @Test
    public void createZone() throws IOException {
        Zone zone = new Zone();

        List<Guest> guests = GenerateEntity.generateGuests(3);
        zone.setGuests(guests);

        List<Channel> channelList = GenerateEntity.generateChannels(5, 2);
        zone.setChannelList(channelList);

        Manager manager = new Manager();
        manager.setName("Alexey");
        manager = dp.createManager(manager);
        zone.setManager(manager);

        zone.setName("Discovery");
        zone.setDateStart(12312313L);
        zone.setDateEnd(12312323L);
        zone.setStatus(false);
        zone = dp.createZone(zone);
        log.info(zone);
    }

    @Test
    public void getZoneById() throws IOException {
        Zone zone = dp.getZoneById(1);
        log.info(zone);
    }

    @Test
    public void deleteZone() throws IOException {
        List<Zone> zoneList = dp.getZones();
        long id = zoneList.get(0).getId();
        Boolean hasDeleted = dp.deleteZone(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateZone() throws IOException {
        List<Zone> zoneList = dp.getZones();
        Zone zone = zoneList.get(0);
        zone.setName(zone.getName() + "_new");
        zone = dp.updateZone(zone);
        log.info(zone);
    }

    @Test
    public void createGuest() throws IOException {
        Guest guest = new Guest();
        guest.setName("Vasily");
        dp.createGuest(guest);
        log.info(guest);
    }

    @Test
    public void getGuests() throws IOException {
        List<Guest> guestList = dp.getGuests();
        log.info(guestList);
    }

    @Test
    public void getGuestById() throws IOException {
        Guest guest = dp.getGuestById(1);
        log.info(guest);
    }

    @Test
    public void deleteGuest() throws IOException {
        List<Guest> guestList = dp.getGuests();
        long id = guestList.get(0).getId();
        Boolean hasDeleted = dp.deleteGuest(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateGuest() throws IOException {
        List<Guest> guestList = dp.getGuests();
        Guest guest = guestList.get(0);
        guest.setName(guest.getName() + "_new");
        guest = dp.updateGuest(guest);
        log.info(guest);
    }

    @Test
    public void getZoneCountNative() throws IOException {
        BigInteger count = dp.getZoneCountNative();
        log.info(count);
    }

    @Test
    public void getZoneCountHQL() throws IOException {
        Long count = dp.getZoneCountHQL();
        log.info(count);
    }

    @Test
    public void getZoneCountCriteria() throws IOException {
        Long count = dp.getZoneCountCriteria();
        log.info(count);
    }

    @Test
    public void checkTimeHQL() throws IOException {
        log.info(String.format(Constants.TIME_TAKEN, (double) dp.checkTimeHQL() / 1000L));
    }

    @Test
    public void checkTimeNative() throws IOException {
        log.info(String.format(Constants.TIME_TAKEN, (double) dp.checkTimeNative() / 1000L));
    }

    @Test
    public void checkTimeCriteria() throws IOException {
        log.info(String.format(Constants.TIME_TAKEN, (double) dp.checkTimeCriteria() / 1000L));
    }

}