package db.jdbc;

import dto.StudentDTO;
import db.jdbc.mapper.StudentsMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

public class StudentsDAO {

    private final Connection connection;
    private final StudentsMapper studentsMapper;

    public StudentsDAO(Connection connection, StudentsMapper studentsMapper) {
        this.connection = connection;
        this.studentsMapper = studentsMapper;
    }

    public Collection<StudentDTO> findByFirstName(String firstName) {
        try {
            String sqlQuery = "select * from students where last_name = ? ";
            PreparedStatement studentStatement = connection.prepareStatement(sqlQuery);
            studentStatement.setString(1, firstName);
            ResultSet resultSet = studentStatement.executeQuery();
            return studentsMapper.map(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void createStudent(StudentDTO student) {
        String sqlQuery = "insert into students (last_name, first_name, course) values(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, student.getLastName());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, String.valueOf(student.getCourse()));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Collection<StudentDTO> getStudents() {
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
}
