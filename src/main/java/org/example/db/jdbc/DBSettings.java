package org.example.db.jdbc;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DBSettings{");
        sb.append("dbUrl='").append(dbUrl).append('\'');
        sb.append(", dbUser='").append("******").append('\'');
        sb.append(", dbPassword='").append("******").append('\'');
        sb.append(", dbDriver='").append(dbDriver).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
