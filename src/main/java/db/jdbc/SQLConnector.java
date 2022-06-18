package db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class SQLConnector {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final DBSettings dbSettings;

    public SQLConnector(DBSettings dbSettings) {
        this.dbSettings = dbSettings;
    }

    public Connection getConnection() {
        try {
            logger.info("Connect");
            Class.forName(dbSettings.getDbDriver());
            return DriverManager.getConnection(
                    dbSettings.getDbUrl(),
                    dbSettings.getDbUser(),
                    dbSettings.getDbPassword());
        } catch (Exception exception) {
            logger.warning("Not connected");
            exception.printStackTrace();
            throw new RuntimeException("Not connected");
        }
    }
}
