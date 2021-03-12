package ru.sfedu.Sync_Hiber.lr2;

import com.sun.source.tree.AssertTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import ru.sfedu.Sync_Hiber.lr2.models.Address;
import ru.sfedu.Sync_Hiber.lr2.models.Admin;

import java.util.List;

import static org.junit.Assert.*;

public class HibernateEntityProviderTest {

    private Logger log = LogManager.getLogger(HibernateEntityProviderTest.class);
    private HibernateEntityProvider dp = new HibernateEntityProvider();

    @Test
    public void createAdmin() {
        Admin admin = new Admin();
        Address address = new Address();
        address.setCity("Rostov-on-Don");
        address.setStreetName("Big Sadovaya");
        admin.setName("Anatoliy");
        admin.setAddress(address);
        dp.createAdmin(admin);
        log.info(admin);
    }

    @Test
    public void getAdmins() {
        List<Admin> admins = dp.getAdmins();
        log.info(admins.toString());
        Assert.assertNotNull(admins);
    }

    @Test
    public void getAdminById() {
        long id = 4;
        Admin admin = dp.getAdminById(id);
        log.info(admin);
        Assert.assertTrue(admin.getId() == id);
    }

    @Test
    public void deleteAdmin() {
        long id = 1;
        Boolean hasDeleted = dp.deleteAdmin(id);
        Assert.assertEquals(hasDeleted, true);
    }

    @Test
    public void updateAdmin() {
        Admin admin = new Admin();
        admin.setId(3);
        admin.setName("Vasily");
        Address address = new Address();
        address.setStreetName("Orbitalnaya");
        address.setCity("Rostov-on-Don");
        admin.setAddress(address);
        Assert.assertTrue(admin.equals(dp.updateAdmin(admin)));
    }
}