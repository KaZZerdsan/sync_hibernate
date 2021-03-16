package ru.sfedu.Sync_Hiber.lr1.api;

import org.junit.Test;
import ru.sfedu.Sync_Hiber.lr1.HiberMetadataProvider;

import java.io.IOException;

public class HiberMetadataProviderTest {

    private HiberMetadataProvider dp = new HiberMetadataProvider();

    @Test
    public void getDatabaseSize() throws IOException {
        dp.getDatabaseSize();
    }

    @Test
    public void getTables() throws IOException {
        dp.getTables();
    }

    @Test
    public void getUsers() throws IOException {
        dp.getUsers();
    }

    @Test
    public void getMySQLVersion() throws IOException {
        dp.getMySQLVersion();
    }
}