package db;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StudentsDAO {

    private final Connection connection;

    public StudentsDAO(Connection connection) {
        this.connection = connection;
    }

    private ResultSet getResultSet() throws Exception {
        String out = "select * from students;";
        Statement statement = connection.createStatement();
        return statement.executeQuery(out);
    }

    public void studentsAllReturn(StudentsMapper studentsMapper) {
        try {
            List<Students> students = studentsMapper.resultSetStudent(getResultSet());
            students.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ResultSet getResultSet(String name) throws SQLException {
        String studentName = "select * from students where last_name = ? ";
        PreparedStatement studentStatement = connection.prepareStatement(studentName);
        studentStatement.setString(1, name);
        studentStatement.execute();
        return studentStatement.executeQuery();
    }

    public void nameByStudentReturn(StudentsMapper studentsMapper, String name) {
        try {
            List<String> strings = studentsMapper.findAStudentByForName(getResultSet(name));
            strings.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String name, String surName, int course) {
        String addStudent = "insert into students (last_name, first_name, course)" +
                " values(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addStudent);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surName);
            preparedStatement.setInt(3, course);
            preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
