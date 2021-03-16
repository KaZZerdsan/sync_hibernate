package ru.sfedu.Sync_Hiber.lr3.mapped;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ru.sfedu.Sync_Hiber.lr3.mapped.models.Admin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class MappedParser {

    private static final Type ADMIN_TYPE = new TypeToken<List<Admin>>() {
    }.getType();

    public static Admin getAdmin(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader jr = new JsonReader(new FileReader(path));
        List<Admin> adminList = gson.fromJson(jr, ADMIN_TYPE);
        return adminList.get(0);
    }
}
