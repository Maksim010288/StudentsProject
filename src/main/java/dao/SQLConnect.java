package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class SQLConnect {
    private final String path = "src/main/resources/connection.properties";
    private final ConnectionPath connectionDB = new ConnectionPath(path);
    private final DBPath connectionPath = connectionDB.getConnectionPath();
    private final Logger logger = Logger.getLogger(Logger.class.getName());

    public Connection getConnect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    connectionPath.getDbURL(),
                    connectionPath.getDbUSER(),
                    connectionPath.getDbPASSWORD());
            Class.forName(connectionPath.getDbDRIVER());
            logger.info("Connect");
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.info("Not connect");
        }
        return connection;
    }
}
