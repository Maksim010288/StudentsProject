package db.jdbc.mapper;

import dto.StudentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsMapper {

    public List<StudentDTO> map(ResultSet resultSet) {
        List<StudentDTO> students = new ArrayList<>();
        try (ResultSet set = resultSet){
            while (set.next()) {
                StudentDTO student = mapStudent(set);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    private StudentDTO mapStudent(ResultSet set) throws SQLException {
        int id = set.getInt(1);
        String lastName = set.getString(2);
        String firstName = set.getString(3);
        int course = set.getInt(4);
        return new StudentDTO(id, lastName, firstName, course);
    }

}
