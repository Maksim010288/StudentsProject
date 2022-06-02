package dao;

import java.io.FileInputStream;
import java.util.Properties;

public class ConnectionPath {
    private final String filePathProperties;

    public ConnectionPath(String filePathProperties) {
        this.filePathProperties = filePathProperties;
    }

    public DBPath getConnectionPath() {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePathProperties);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String url = properties.getProperty("dbURL");
            String user = properties.getProperty("dbUser");
            String password = properties.getProperty("dbPassword");
            String driver = properties.getProperty("driver");
            return new DBPath(url, user, password, driver);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
