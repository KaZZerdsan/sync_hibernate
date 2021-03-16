package ru.sfedu.Sync_Hiber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Sync_Hiber.lr1.HiberMetadataProvider;
import ru.sfedu.Sync_Hiber.lr2.HibernateEntityProvider;
import ru.sfedu.Sync_Hiber.lr2.Lab2Parser;
import ru.sfedu.Sync_Hiber.lr2.models.Address;
import ru.sfedu.Sync_Hiber.lr2.models.Admin;
import ru.sfedu.Sync_Hiber.lr3.joined.JoinedParser;
import ru.sfedu.Sync_Hiber.lr3.mapped.MappedParser;
import ru.sfedu.Sync_Hiber.lr3.singleTable.STableParser;
import ru.sfedu.Sync_Hiber.lr3.tablePerClass.PerClassParser;
import ru.sfedu.Sync_Hiber.lr4.AssociationParser;
import ru.sfedu.Sync_Hiber.lr4.models.Channel;
import ru.sfedu.Sync_Hiber.lr5.HibernateRelationsProvider;
import ru.sfedu.Sync_Hiber.lr5.RelationsParser;
import ru.sfedu.Sync_Hiber.lr5.models.Zone;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {

        log.info(String.join(",", args));
        if (args.length < 1) {
            log.error(Constants.LOG_NO_ARGS);
            return;
        }
        switch (Integer.parseInt(args[0])) {
            case 1:
                HiberMetadataProvider dp = new HiberMetadataProvider();
                dp.getDatabaseSize();
                dp.getTables();
                dp.getDatabaseSize();
                dp.getMySQLVersion();
                break;
            case 2:
                if (args.length > 1) {
                    HibernateEntityProvider lr2 = new HibernateEntityProvider();
                    switch(args[1].toUpperCase(Locale.ROOT)) {
                        case "CREATE":
                            try {
                                Admin admin = Lab2Parser.getAdmin(args[2]);
                                admin = lr2.createAdmin(admin);
                                log.info(admin);
                            } catch (Exception e) {
                                log.error(e);
                                log.error(Constants.BAD_PATH);
                            }
                            break;
                        case "GET":
                            List<Admin> adminList = lr2.getAdmins();
                            log.info(adminList);
                            break;
                        case "GETBYID":
                            if (args.length > 2) {
                                try {
                                    Long id = Long.parseLong(args[2]);
                                    Admin admin = lr2.getAdminById(id);
                                    log.info(admin);
                                } catch (Exception e) {
                                    log.error(Constants.BAD_ARG);
                                }
                            } else {
                                log.error(Constants.TOO_FEW_ARGS);
                            }
                            break;
                        case "DELETE":
                            if (args.length > 2) {
                                try {
                                    Long id = Long.parseLong(args[2]);
                                    log.info(lr2.deleteAdmin(id));
                                } catch (Exception e) {
                                    log.error(Constants.BAD_ARG);
                                }
                            }
                            break;
                        case "UPDATE":
                            try {
                                Admin admin = Lab2Parser.getAdmin(args[2]);
                                admin = lr2.updateAdmin(admin);
                                log.info(admin);
                            } catch (Exception e) {
                                log.error(e);
                                log.error(Constants.BAD_PATH);
                            }
                            break;
                    }
                } else {
                    log.error(Constants.TOO_FEW_ARGS);
                }
                break;
            case 3:
                switch(args[1].toUpperCase(Locale.ROOT)) {
                    case "MAPPED":
                        ru.sfedu.Sync_Hiber.lr3.mapped.HibernateEntityProvider lr3 = new ru.sfedu.Sync_Hiber.lr3.mapped.HibernateEntityProvider();
                        switch(args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATE":
                                if (args.length > 2) {
                                    ru.sfedu.Sync_Hiber.lr3.mapped.models.Admin admin = MappedParser.getAdmin(args[3]);
                                    admin = lr3.createAdmin(admin);
                                    log.info(admin);
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "GET":
                                List<ru.sfedu.Sync_Hiber.lr3.mapped.models.Admin> adminList = lr3.getAdmins();
                                log.info(adminList);
                                break;
                            case "GETBYID":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[2]);
                                        ru.sfedu.Sync_Hiber.lr3.mapped.models.Admin admin = lr3.getAdminById(id);
                                        log.info(admin);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[2]);
                                        log.info(lr3.deleteAdmin(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    try {
                                        ru.sfedu.Sync_Hiber.lr3.mapped.models.Admin admin = MappedParser.getAdmin(args[3]);
                                        admin = lr3.updateAdmin(admin);
                                        log.info(admin);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                        }
                        break;
                    case "SINGLETABLE":
                        ru.sfedu.Sync_Hiber.lr3.singleTable.HibernateEntityProvider lr31 = new ru.sfedu.Sync_Hiber.lr3.singleTable.HibernateEntityProvider();
                        switch(args[1].toUpperCase(Locale.ROOT)) {
                            case "CREATE":
                                if (args.length > 2) {
                                    ru.sfedu.Sync_Hiber.lr3.singleTable.models.Admin admin = STableParser.getAdmin(args[2]);
                                    admin = lr31.createAdmin(admin);
                                    log.info(admin);
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "GET":
                                List<ru.sfedu.Sync_Hiber.lr3.singleTable.models.Admin> adminList = lr31.getAdmins();
                                log.info(adminList);
                                break;
                            case "GETBYID":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[2]);
                                        ru.sfedu.Sync_Hiber.lr3.singleTable.models.Admin admin = lr31.getAdminById(id);
                                        log.info(admin);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[2]);
                                        log.info(lr31.deleteAdmin(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    try {
                                        ru.sfedu.Sync_Hiber.lr3.singleTable.models.Admin admin = STableParser.getAdmin(args[2]);
                                        admin = lr31.updateAdmin(admin);
                                        log.info(admin);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                        }
                        break;
                    case "TABLEPERCLASS":
                        ru.sfedu.Sync_Hiber.lr3.tablePerClass.HibernateEntityProvider lr32 = new ru.sfedu.Sync_Hiber.lr3.tablePerClass.HibernateEntityProvider();
                        switch(args[1].toUpperCase(Locale.ROOT)) {
                            case "CREATE":
                                if (args.length > 2) {
                                    ru.sfedu.Sync_Hiber.lr3.tablePerClass.models.Admin admin = PerClassParser.getAdmin(args[2]);
                                    admin = lr32.createAdmin(admin);
                                    log.info(admin);
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "GET":
                                List<ru.sfedu.Sync_Hiber.lr3.tablePerClass.models.Admin> adminList = lr32.getAdmins();
                                log.info(adminList);
                                break;
                            case "GETBYID":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[2]);
                                        ru.sfedu.Sync_Hiber.lr3.tablePerClass.models.Admin admin = lr32.getAdminById(id);
                                        log.info(admin);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[2]);
                                        log.info(lr32.deleteAdmin(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    try {
                                        ru.sfedu.Sync_Hiber.lr3.tablePerClass.models.Admin admin = PerClassParser.getAdmin(args[2]);
                                        admin = lr32.updateAdmin(admin);
                                        log.info(admin);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                        }
                        break;
                    case "JOINED":
                        ru.sfedu.Sync_Hiber.lr3.joined.HibernateEntityProvider lr33 = new ru.sfedu.Sync_Hiber.lr3.joined.HibernateEntityProvider();
                        switch(args[1].toUpperCase(Locale.ROOT)) {
                            case "CREATE":
                                if (args.length > 4) {
                                    ru.sfedu.Sync_Hiber.lr3.joined.models.Admin admin = JoinedParser.getAdmin(args[2]);
                                    admin = lr33.createAdmin(admin);
                                    log.info(admin);
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "GET":
                                List<ru.sfedu.Sync_Hiber.lr3.joined.models.Admin> adminList = lr33.getAdmins();
                                log.info(adminList);
                                break;
                            case "GETBYID":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[2]);
                                        ru.sfedu.Sync_Hiber.lr3.joined.models.Admin admin = lr33.getAdminById(id);
                                        log.info(admin);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[2]);
                                        log.info(lr33.deleteAdmin(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    try {
                                        ru.sfedu.Sync_Hiber.lr3.joined.models.Admin admin = JoinedParser.getAdmin(args[2]);
                                        admin = lr33.updateAdmin(admin);
                                        log.info(admin);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                } else {
                                    log.error(Constants.TOO_FEW_ARGS);
                                }
                                break;
                        }
                }
                break;
            case 4:
                if (args.length > 1) {
                    ru.sfedu.Sync_Hiber.lr4.HibernateEntityProvider lr4 = new ru.sfedu.Sync_Hiber.lr4.HibernateEntityProvider();
                    switch (args[1].toUpperCase(Locale.ROOT)) {
                        case "CREATE":
                            if (args.length > 2) {
                                Channel channel = AssociationParser.getChannel(args[2]);
                                channel = lr4.createChannel(channel);
                                log.info(channel);
                            } else {
                                log.error(Constants.TOO_FEW_ARGS);
                            }
                            break;
                        case "GET":
                            List<Channel> channelList = lr4.getChannels();
                            log.info(channelList);
                            break;
                        case "GETBYID":
                            if (args.length > 2) {
                                try {
                                    Long id = Long.parseLong(args[2]);
                                    Channel channel = lr4.getChannelById(id);
                                    log.info(channel);
                                } catch (Exception e) {
                                    log.error(Constants.BAD_ARG);
                                }
                            } else {
                                log.error(Constants.TOO_FEW_ARGS);
                            }
                            break;
                        case "UPDATE":
                            if (args.length > 2) {
                                Channel channel = AssociationParser.getChannel(args[2]);
                                channel = lr4.updateChannel(channel);
                                log.info(channel);
                            } else {
                                log.error(Constants.TOO_FEW_ARGS);
                            }
                            break;
                        case "DELETE":
                            if (args.length > 2) {
                                try {
                                    Long id = Long.parseLong(args[2]);
                                    Boolean isDeleted = lr4.deleteChannel(id);
                                    log.info(isDeleted);
                                    break;
                                } catch (Exception e) {
                                    log.error(Constants.BAD_ARG);
                                    break;
                                }
                            } else {
                                log.error(Constants.TOO_FEW_ARGS);
                                break;
                            }
                    }
                } else {
                    log.error(Constants.TOO_FEW_ARGS);
                    break;
                }
                break;
            case 5:
                if (args.length > 2) {
                    HibernateRelationsProvider lr5 = new HibernateRelationsProvider();
                    Zone zone;
                    switch (args[1].toUpperCase(Locale.ROOT)) {
                        case "CREATE":
                            zone = RelationsParser.getZone(args[2]);
                            zone = lr5.createZone(zone);
                            log.info(zone);
                            break;
                        case "GET":
                            List<Zone> zoneList = lr5.getZones();
                            log.info(zoneList);
                            break;
                        case "GETBYID":
                            try {
                                Long id = Long.parseLong(args[2]);
                                zone = lr5.getZoneById(id);
                                log.info(zone);
                            } catch (Exception e) {
                                log.error(Constants.BAD_ARG);
                            }
                            break;
                        case "DELETE":
                            try {
                                Long id = Long.parseLong(args[2]);
                                Boolean isDeleted = lr5.deleteZone(id);
                                log.info(isDeleted);
                            } catch (Exception e) {
                                log.error(Constants.BAD_ARG);
                            }
                            break;
                        case "UPDATE":
                            zone = RelationsParser.getZone(args[2]);
                            zone = lr5.updateZone(zone);
                            log.info(zone);
                            break;
                    }
                }
                break;
            default:
                log.info(Constants.BAD_ARG);
                break;
        }
    }
}
