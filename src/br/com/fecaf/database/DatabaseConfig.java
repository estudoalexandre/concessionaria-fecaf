package br.com.fecaf.database;

public class DatabaseConfig {
    public static final String DATABASE = "concessionaria_fecaf";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static String getDatabase() {
        return DATABASE;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
