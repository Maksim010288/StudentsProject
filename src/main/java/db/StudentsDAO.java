package db;

import mapper.StudentsMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsDAO {

    private final Connection connection;

    public StudentsDAO(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getResultSet() {
        try {
        String out = "select * from students;";
        Statement statement = connection.createStatement();
        return statement.executeQuery(out);
    }catch (Exception e){
        e.printStackTrace();
        }
        return null;
    }

    public void returnAll(List<Students> students) {
            students.stream()
                    .sorted(Comparator.comparing(Students::getCourse))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
    }

    private ResultSet getResultSet(String name) throws SQLException {
        String studentName = "select * from students where last_name = ? ";
        PreparedStatement studentStatement = connection.prepareStatement(studentName);
        studentStatement.setString(1, name);
        studentStatement.execute();
        return studentStatement.executeQuery();
    }

    public List<String> getByForName(ResultSet resultSet) {
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

    public void returnName(String name) {
        try {
            List<String> strings = getByForName(getResultSet(name));
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
