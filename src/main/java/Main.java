import db.jdbc.DBSettings;
import db.jdbc.DbSettingsProvider;
import db.jdbc.SQLConnector;
import db.jdbc.StudentsDAO;
import db.jdbc.mapper.StudentsMapper;

public class Main {
    public static void main(String[] args) {
        DbSettingsProvider dbSettingsProvider = new DbSettingsProvider("src/main/resources/connection.properties");
        DBSettings dbSettings = dbSettingsProvider.getDBSettings();
        SQLConnector connector = new SQLConnector(dbSettings);
        StudentsDAO studentsDAO = new StudentsDAO(connector.getConnection(), new StudentsMapper());


       // new MenuWindow(studentsDAO);

//        studentsDAO.getStudents()
//                .stream()
//                .sorted(Comparator.comparing(Student::getCourse))
//                .map(s -> String.format("%15s %15s, course: %3s", s.getFirstName(), s.getLastName(), s.getCourse()))
//                .forEach(System.out::println);
//        studentsDAO.findByFirstName("1")
//                .forEach(System.out::println);
    }
}
