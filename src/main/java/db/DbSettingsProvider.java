package db;

import java.io.FileInputStream;
import java.util.Properties;

public class DbSettingsProvider {
    private final String propertiesFilePath;

    public DbSettingsProvider(String propertiesFilePath) {
        this.propertiesFilePath = propertiesFilePath;
    }

    public DBSettings getDBSettings() {
        try {
            FileInputStream fileInputStream = new FileInputStream(propertiesFilePath);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String url = properties.getProperty("dbURL");
            String user = properties.getProperty("dbUser");
            String password = properties.getProperty("dbPassword");
            String driver = properties.getProperty("driver");
            return new DBSettings(url, user, password, driver);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
