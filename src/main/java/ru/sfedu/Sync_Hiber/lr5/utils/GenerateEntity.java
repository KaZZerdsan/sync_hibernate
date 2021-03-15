package ru.sfedu.Sync_Hiber.lr5.utils;

import ru.sfedu.Sync_Hiber.lr5.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateEntity {

    public static List<Guest> generateGuests(int count) {
        List<Guest> guests = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Guest guest = new Guest();
            guest.setName(generateString());
            guests.add(guest);
        }
        return guests;
    }

    public static List<Manager> generateManagers(int count) {
        List<Manager> managerList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Manager manager = new Manager();
            manager.setName(generateString());
            manager.setId(generateLong());
            managerList.add(manager);
        }
        return managerList;
    }

    public static List<Speaker> generateSpeakers(int count) {
        List<Speaker> speakerList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Speaker speaker = new Speaker();
            speaker.setName(generateString());
            speaker.setId(generateLong());
            speakerList.add(speaker);
        }
        return speakerList;
    }

    public static List<Zone> generateZones(int count, int channelsCount) {
        List<Zone> zoneList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Zone zone = new Zone();
            zone.setId(generateLong());
            zone.setName(generateString());
            zone.setDateStart(Long.valueOf(generateInt()));
            zone.setDateEnd(Long.valueOf(generateInt()));
            zone.setStatus(generateBoolean());
            zone.setChannelList(generateChannels(channelsCount, 5));
            zoneList.add(zone);
        }
        return zoneList;
    }

    public static List<Channel> generateChannels(int count, int speakersCount) {
        List<Channel> channelList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Channel channel = new Channel();
            channel.setId(generateLong());
            channel.setName(generateString());
            channel.setStatus(generateBoolean());
            channel.setLanguage(generateString());
            channel.setSpeakers(generateSpeakers(speakersCount));
            channelList.add(channel);
        }
        return channelList;
    }

    private static String generateString() {
        Random random = new Random();
        char[] word = new char[random.nextInt(9) + 5];
        for (int i = 0; i < word.length; i++) {
            word[i] = (char) ('a' + random.nextInt(26));
        }
        return new String(word);
    }

    private static int generateInt() {
        return new Random().nextInt(10000000);
    }

    public static Long generateLong() {
        return Long.valueOf(generateInt());
    }

    private static boolean generateBoolean() {
        return new Random().nextInt(100) % 2 == 1;
    }
}
