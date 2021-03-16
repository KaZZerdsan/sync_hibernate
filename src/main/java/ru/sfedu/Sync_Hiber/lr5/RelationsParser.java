package ru.sfedu.Sync_Hiber.lr5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ru.sfedu.Sync_Hiber.lr5.models.Zone;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class RelationsParser {

    private static final Type ZONE_TYPE = new TypeToken<List<Zone>>() {
    }.getType();

    public static Zone getZone(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader jr = new JsonReader(new FileReader(path));
        List<Zone> channelList = gson.fromJson(jr, ZONE_TYPE);
        return channelList.get(0);
    }
}
