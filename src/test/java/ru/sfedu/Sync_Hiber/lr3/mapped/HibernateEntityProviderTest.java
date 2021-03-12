package ru.sfedu.Sync_Hiber.lr3.mapped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import ru.sfedu.Sync_Hiber.lr3.mapped.HibernateEntityProvider;
import ru.sfedu.Sync_Hiber.lr3.mapped.models.Admin;

import java.util.List;

public class HibernateEntityProviderTest {

    private HibernateEntityProvider dp = new HibernateEntityProvider();
    private Logger log = LogManager.getLogger(HibernateEntityProviderTest.class);

    @Test
    public void createAdmin() {
        Admin admin = new Admin();
        admin.setName("Anatoliy");
        admin.setAge(38);
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
        Assert.assertTrue(admin.equals(dp.updateAdmin(admin)));
    }
}