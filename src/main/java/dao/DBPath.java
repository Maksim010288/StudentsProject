package dao;

public class DBPath {
   private final String dbURL, dbUSER, dbPASSWORD, dbDRIVER;

    public DBPath(String dbURL, String dbUSER, String dbPASSWORD, String dbDriver) {
        this.dbURL = dbURL;
        this.dbUSER = dbUSER;
        this.dbPASSWORD = dbPASSWORD;
        this.dbDRIVER = dbDriver;
    }

    public String getDbURL() {
        return dbURL;
    }

    public String getDbUSER() {
        return dbUSER;
    }

    public String getDbPASSWORD() {
        return dbPASSWORD;
    }

    public String getDbDRIVER() {
        return dbDRIVER;
    }
}
