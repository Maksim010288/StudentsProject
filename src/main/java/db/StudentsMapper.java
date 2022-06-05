package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsMapper {

    public List<Students> resultSetStudent(ResultSet resultSet) {
        List<Students> students = new ArrayList<>();
        try (ResultSet set = resultSet){
            while (set.next()) {
                int id = set.getInt(1);
                String lastName = set.getString(2);
                String firstName = set.getString(3);
                int course = set.getInt(4);
                students.add(new Students(id, lastName, firstName, course));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


    public List<String> findAStudentByForName(ResultSet resultSet) {
        List<String> studentList = new ArrayList<>();
        try (ResultSet setStudent = resultSet){
                while (setStudent.next()) {
                    int id = setStudent.getInt(1);
                    String student = setStudent.getString(2);
                    studentList.add(id + " " + student);
                }
            } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return studentList;
    }
}
