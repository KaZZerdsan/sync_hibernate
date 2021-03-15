package ru.sfedu.Sync_Hiber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Sync_Hiber.lr1.HiberMetadataProvider;
import ru.sfedu.Sync_Hiber.lr2.models.Admin;
import ru.sfedu.Sync_Hiber.lr5.utils.GenerateEntity;

import java.util.List;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        if (args.length < 1) {
            log.error(Constants.LOG_NO_ARGS);
            return;
        }
        switch (args[0]) {
            case "1":
                HiberMetadataProvider dp = new HiberMetadataProvider();
                dp.getDatabaseSize();
                dp.getTables();
                dp.getDatabaseSize();
                dp.getMySQLVersion();
                break;
            case "2":
        }
    }
}
