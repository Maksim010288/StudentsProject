package org.example;

import org.example.db.jdbc.DBSettings;
import org.example.db.jdbc.DbSettingsProvider;
import org.example.db.jdbc.SQLConnector;
import org.example.db.jdbc.StudentJdbcRepository;
import org.example.db.jdbc.mapper.StudentsMapper;
import org.example.service.StudentService;
import org.example.service.converter.StudentConverter;
import org.example.ui.MenuWindow;

import static java.lang.String.format;

public class MainJDBC {
    public static void main(String[] args) {
        DbSettingsProvider dbSettingsProvider = new DbSettingsProvider("src/main/resources/connection.properties");
        DBSettings dbSettings = dbSettingsProvider.getDBSettings();
        SQLConnector connector = new SQLConnector(dbSettings);
        StudentJdbcRepository studentJdbcRepository = new StudentJdbcRepository(connector.getConnection(), new StudentsMapper());
        StudentConverter converter = new StudentConverter();
        StudentService service = new StudentService(studentJdbcRepository, converter);
        new MenuWindow(service);

//        studentJdbcRepository.getStudents()
//                .stream()
//                .sorted(Comparator.comparing(StudentEntity::getCourse))
//                .map(s -> String.format("%15s %15s, course: %3s", s.getFirstName(), s.getLastName(), s.getCourse()))
//                .forEach(System.out::println);
//        studentJdbcRepository.findByFirstName("1")
//                .forEach(System.out::println);
    }
}
