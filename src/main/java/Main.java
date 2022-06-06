import db.*;
import mapper.StudentsMapper;

public class Main {
    public static void main(String[] args) {
        DbSettingsProvider dbSettingsProvider = new DbSettingsProvider("src/main/resources/connection.properties");
        DBSettings dbSettings = dbSettingsProvider.getDBSettings();
        SQLConnector connector = new SQLConnector(dbSettings);
        StudentsDAO requests = new StudentsDAO(connector.getConnection());
        StudentsMapper studentsMapper = new StudentsMapper();
        requests.returnAll(studentsMapper.map(requests.getResultSet()));
        requests.returnName("Andriy");
//        requests.addStudent("Serhiy", "Romaniyk", 3);
    }
}
