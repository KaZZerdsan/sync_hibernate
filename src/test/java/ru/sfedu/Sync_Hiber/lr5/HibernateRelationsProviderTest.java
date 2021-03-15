package ru.sfedu.Sync_Hiber.lr5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.Sync_Hiber.Constants;
import ru.sfedu.Sync_Hiber.lr5.models.*;
import ru.sfedu.Sync_Hiber.lr5.utils.GenerateEntity;

import java.math.BigInteger;
import java.util.List;

public class HibernateRelationsProviderTest {

    private HibernateRelationsProvider dp = new HibernateRelationsProvider();
    private Logger log = LogManager.getLogger(HibernateRelationsProviderTest.class);

    @Test
    public void getManagers() {
        List<Manager> managerList = dp.getManagers();
        log.info(managerList);
    }

    @Test
    public void createManager() {
        Manager manager = new Manager();
        manager.setName("Mikhail");
        dp.createManager(manager);
        log.info(manager);
    }

    @Test
    public void getManagerById() {
        Manager manager = dp.getManagerById(6);
        log.info(manager);
    }

    @Test
    public void deleteManager() {
        List<Manager> managerList = dp.getManagers();
        long id = managerList.get(0).getId();
        Boolean hasDeleted = dp.deleteManager(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateManager() {
        List<Manager> managerList = dp.getManagers();
        Manager manager = managerList.get(0);
        manager.setName(manager.getName() + "_new");
        dp.updateManager(manager);
        log.info(manager);
    }

    @Test
    public void getSpeakers() {
        List<Speaker> speakerList = dp.getSpeakers();
        log.info(speakerList);
    }

    @Test
    public void createSpeaker() {
        Speaker speaker = new Speaker();
        speaker.setName("Eugene");
        speaker = dp.createSpeaker(speaker);
        log.info(speaker);
    }

    @Test
    public void getSpeakerById() {
        Speaker speaker = dp.getSpeakerById(1);
        log.info(speaker);
    }

    @Test
    public void deleteSpeaker() {
        List<Speaker> speakerList = dp.getSpeakers();
        long id = speakerList.get(0).getId();
        Boolean hasDeleted = dp.deleteSpeaker(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateSpeaker() {
        List<Speaker> speakerList = dp.getSpeakers();
        Speaker speaker = speakerList.get(0);
        speaker.setName(speaker.getName() + "_new");
        speaker = dp.updateSpeaker(speaker);
        log.info(speaker);
    }

    @Test
    public void getChannels() {
        List<Channel> channelList = dp.getChannels();
        log.info(channelList);
    }

    @Test
    public void createChannel() {
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
    public void getChannelById() {
        Channel channel = dp.getChannelById(2);
        log.info(channel);
    }

    @Test
    public void deleteChannel() {
        List<Channel> channelList = dp.getChannels();
        long id = channelList.get(0).getId();
        Boolean hasDeleted = dp.deleteChannel(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateChannel() {
        List<Channel> channelList = dp.getChannels();
        Channel channel = channelList.get(0);
        channel.setName(channel.getName() + "_new");
        channel = dp.updateChannel(channel);
        log.info(channel);
    }

    @Test
    public void getZones() {
        List<Zone> zoneList = dp.getZones();
        log.info(zoneList);
    }

    @Test
    public void createZone() {
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
    public void getZoneById() {
        Zone zone = dp.getZoneById(1);
        log.info(zone);
    }

    @Test
    public void deleteZone() {
        List<Zone> zoneList = dp.getZones();
        long id = zoneList.get(0).getId();
        Boolean hasDeleted = dp.deleteZone(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateZone() {
        List<Zone> zoneList = dp.getZones();
        Zone zone = zoneList.get(0);
        zone.setName(zone.getName() + "_new");
        zone = dp.updateZone(zone);
        log.info(zone);
    }

    @Test
    public void createGuest() {
        Guest guest = new Guest();
        guest.setName("Vasily");
        dp.createGuest(guest);
        log.info(guest);
    }

    @Test
    public void getGuests() {
        List<Guest> guestList = dp.getGuests();
        log.info(guestList);
    }

    @Test
    public void getGuestById() {
        Guest guest = dp.getGuestById(1);
        log.info(guest);
    }

    @Test
    public void deleteGuest() {
        List<Guest> guestList = dp.getGuests();
        long id = guestList.get(0).getId();
        Boolean hasDeleted = dp.deleteGuest(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateGuest() {
        List<Guest> guestList = dp.getGuests();
        Guest guest = guestList.get(0);
        guest.setName(guest.getName() + "_new");
        guest = dp.updateGuest(guest);
        log.info(guest);
    }

    @Test
    public void getZoneCountNative() {
        BigInteger count = dp.getZoneCountNative();
        log.info(count);
    }

    @Test
    public void getZoneCountHQL() {
        Long count = dp.getZoneCountHQL();
        log.info(count);
    }

    @Test
    public void getZoneCountCriteria() {
        Long count = dp.getZoneCountCriteria();
        log.info(count);
    }

    @Test
    public void checkTimeHQL() {
        log.info(String.format(Constants.TIME_TAKEN, (double) dp.checkTimeHQL() / 1000L));
    }

    @Test
    public void checkTimeNative() {
        log.info(String.format(Constants.TIME_TAKEN, (double) dp.checkTimeHQL() / 1000L));
    }

    @Test
    public void checkTimeCriteria() {
        log.info(String.format(Constants.TIME_TAKEN, (double) dp.checkTimeCriteria() / 1000L));
    }

}