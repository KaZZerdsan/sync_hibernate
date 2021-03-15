package ru.sfedu.Sync_Hiber;

public class Constants {
    public static final String LOG_NO_ARGS = "No arguments were given";

    //  LR 1
    public static final String LOG_DB_SIZE_IN_MB = "DB size is %s Mb";
    public static final String LOG_TABLES = "Tables: ";
    public static final String LOG_USERS = "Users: ";
    public static final String LOG_VERSION = "MySQL version: ";

    public static final String DB_SIZE_QUERY = "SELECT SUM(ROUND(((DATA_LENGTH + INDEX_LENGTH) / 1024 / 1024), 2)) AS \"SIZE IN MB\" FROM INFORMATION_SCHEMA.TABLES ;";
    public static final String ALL_TABLES_QUERY = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'sync_hiber';";
    public static final String GET_USERS_QUERY = "SELECT user FROM mysql.user;";
    public static final String GET_VERSION_QUERY = "SELECT VERSION();";

    //  LR 2-5

    public static final String GET_QUERY = "FROM %s";

    //  LR 5

    public static final String ZONE = "Zone";
    public static final String GET_COUNT = "select count(*) from %s";
    public static final String TIME_TAKEN = "Time: %ss";
}