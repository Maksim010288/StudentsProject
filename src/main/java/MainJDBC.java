import db.jdbc.DBSettings;
import db.jdbc.DbSettingsProvider;
import db.jdbc.SQLConnector;
import db.jdbc.StudentsDAO;
import db.jdbc.mapper.StudentsMapper;
import db.orm.entity.StudentEntity;
import dto.StudentDTO;
import service.converter.StudentConverter;
import ui.MenuWindow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class MainJDBC {
    public static void main(String[] args) {
        DbSettingsProvider dbSettingsProvider = new DbSettingsProvider("src/main/resources/connection.properties");
        DBSettings dbSettings = dbSettingsProvider.getDBSettings();
        SQLConnector connector = new SQLConnector(dbSettings);
        StudentsDAO studentsDAO = new StudentsDAO(connector.getConnection(), new StudentsMapper());
        new MenuWindow(studentsDAO);

        studentsDAO.getStudents()
                .stream()
                .sorted(Comparator.comparing(StudentDTO::getCourse))
                .map(s -> String.format("%15s %15s, course: %3s", s.getFirstName(), s.getLastName(), s.getCourse()))
                .forEach(System.out::println);
        studentsDAO.findByFirstName("1")
                .forEach(System.out::println);
    }
}
