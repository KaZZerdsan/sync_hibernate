package ru.sfedu.Sync_Hiber.lr4;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ru.sfedu.Sync_Hiber.lr4.models.Channel;
import ru.sfedu.Sync_Hiber.lr4.models.Speaker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class AssociationParser {

    private static final Type CHANNEL_TYPE = new TypeToken<List<Channel>>() {
    }.getType();

    private static final Type SPEAKER_TYPE = new TypeToken<List<Speaker>>() {
    }.getType();

    public static Channel getChannel(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader jr = new JsonReader(new FileReader(path));
        List<Channel> channelList = gson.fromJson(jr, CHANNEL_TYPE);
        return channelList.get(0);
    }

    public static Speaker getSpeaker(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader jr = new JsonReader(new FileReader(path));
        List<Speaker> adminList = gson.fromJson(jr, SPEAKER_TYPE);
        return adminList.get(0);
    }
}
