package org.example.db.jdbc;

import org.example.db.StudentRepository;
import org.example.db.entity.StudentEntity;
import org.example.db.jdbc.mapper.StudentsMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

public class StudentJdbcRepository implements StudentRepository {

    private final Connection connection;
    private final StudentsMapper studentsMapper;

    public StudentJdbcRepository(Connection connection, StudentsMapper studentsMapper) {
        this.connection = connection;
        this.studentsMapper = studentsMapper;
    }

    public Collection<StudentEntity> findByFirstName(String firstName) {
        try {
            String sqlQuery = "select * from students where first_name = ?";
            PreparedStatement studentStatement = connection.prepareStatement(sqlQuery);
            studentStatement.setString(1, firstName);
            ResultSet resultSet = studentStatement.executeQuery();
            return studentsMapper.map(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<StudentEntity> getStudents() {
        try {
            String sqlQuery = "select * from students;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            return studentsMapper.map(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(StudentEntity student) {
        String sqlQuery = "insert into students (course, first_name, last_name) values(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, String.valueOf(student.getCourse()));
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(StudentEntity studentEntity) {
        String update = "update students set last_name = ?, first_name = ?, course = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, studentEntity.getFirstName());
            preparedStatement.setString(2, studentEntity.getLastName());
            preparedStatement.setInt(3, studentEntity.getCourse());
            preparedStatement.setInt(4, studentEntity.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public StudentEntity findById(int id) {
        String byId = "select * from students where id =" + id;
        StudentEntity entity = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(byId);
            while (set.next()) {
                if (set.getInt("id") == id) {
                    int idNum = set.getInt("id");
                    int course = set.getInt("course");
                    String fname = set.getString("first_name");
                    String lname = set.getString("last_name");

                    entity = new StudentEntity(idNum, course, fname, lname);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
