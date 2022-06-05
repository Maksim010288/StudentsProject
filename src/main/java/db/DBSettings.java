package db;

public class DBSettings {
    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;
    private final String dbDriver;

    public DBSettings(String dbUrl, String dbUser, String dbPassword, String dbDriver) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbDriver = dbDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }
}
