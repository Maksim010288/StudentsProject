package mapper;

import db.Students;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentsMapper {

    public List<Students> map(ResultSet resultSet) {
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



}
