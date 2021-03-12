package ru.sfedu.Sync_Hiber.lr1.api;

import org.junit.Test;
import ru.sfedu.Sync_Hiber.lr1.HiberMetadataProvider;

public class HiberMetadataProviderTest {

    private HiberMetadataProvider dp = new HiberMetadataProvider();

    @Test
    public void getDatabaseSize() {
        dp.getDatabaseSize();
    }

    @Test
    public void getTables() {
        dp.getTables();
    }

    @Test
    public void getUsers() {
        dp.getUsers();
    }

    @Test
    public void getMySQLVersion() {
        dp.getMySQLVersion();
    }
}