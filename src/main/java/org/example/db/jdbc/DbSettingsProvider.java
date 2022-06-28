package org.example.db.jdbc;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class DbSettingsProvider {
    private static final Logger log = Logger.getLogger(DbSettingsProvider.class);
    private final String propertiesFilePath;

    public DbSettingsProvider(String propertiesFilePath) {
        this.propertiesFilePath = propertiesFilePath;
    }

    public DBSettings getDBSettings() {
        log.trace("getDBSettings start");
        DBSettings dbSettings;
        try {
            FileInputStream fileInputStream = new FileInputStream(propertiesFilePath);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String url = properties.getProperty("dbURL");
            String user = properties.getProperty("dbUser");
            String password = properties.getProperty("dbPassword");
            String driver = properties.getProperty("driver");
            dbSettings = new DBSettings(url, user, password, driver);
            log.debug(String.format("DB settings: %s", dbSettings));
        } catch (Exception e) {
            log.error("Couldn't read DB settings", e);
            throw new RuntimeException(e);
        }
        log.trace("getDBSettings end");
        return dbSettings;
    }
}
