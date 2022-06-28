package org.example.db.jdbc.mapper;

import org.example.db.entity.StudentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsMapper {

    public List<StudentEntity> map(ResultSet resultSet) {
        List<StudentEntity> students = new ArrayList<>();
        try (ResultSet set = resultSet) {
            while (set.next()) {
                StudentEntity student = mapStudent(set);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


    private StudentEntity mapStudent(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String lastName = set.getString("last_name");
        String firstName = set.getString("first_name");
        int course = set.getInt("course");
        return new StudentEntity(id, course, lastName, firstName);
    }

}
