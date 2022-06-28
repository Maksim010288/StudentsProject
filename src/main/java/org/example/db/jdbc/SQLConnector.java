package org.example.db.jdbc;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnector {
    private static final Logger log = Logger.getLogger(SQLConnector.class);
    private final DBSettings dbSettings;

    public SQLConnector(DBSettings dbSettings) {
        this.dbSettings = dbSettings;
    }

    public Connection getConnection() {
        try {
            log.info("Connect");
            Class.forName(dbSettings.getDbDriver());
            return DriverManager.getConnection(
                    dbSettings.getDbUrl(),
                    dbSettings.getDbUser(),
                    dbSettings.getDbPassword());
        } catch (Exception e) {
            log.error("Not connected", e);
            throw new RuntimeException("Not connected");
        }
    }
}
