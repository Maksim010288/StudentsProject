import db.*;

public class Main {
    public static void main(String[] args) {
        DbSettingsProvider dbSettingsProvider = new DbSettingsProvider( "src/main/resources/connection.properties");
        DBSettings dbSettings = dbSettingsProvider.getDBSettings();
        SQLConnector connector = new SQLConnector(dbSettings);
        StudentsDAO requests = new StudentsDAO(connector.getConnection());
        StudentsMapper studentsMapper = new StudentsMapper();
        requests.studentsAllReturn(studentsMapper);
        requests.nameByStudentReturn(studentsMapper,"Andriy");
    }
}
