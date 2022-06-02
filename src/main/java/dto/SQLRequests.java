package dto;

import java.sql.*;

public class SQLRequests {

    private final Connection connection;

    public SQLRequests(Connection connection) {
        this.connection = connection;
    }

    public void getAllStudents() {
        try {
            String out = "select * from students;";
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(out);
            while (set.next()) {
                int id = set.getInt(1);
                String surName = set.getString(2);
                String name = set.getString(3);
                int course = set.getInt(4);
                String output = String.format("Студент № %s\n%s %s, %s  курс",
                        id,
                        surName,
                        name,
                        course);
                System.out.println(output);
            }
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

    public void findAStudentByForName(String name) {
        String studentName = "select * from students where last_name = ? ";
        try {
            PreparedStatement studentStatement = connection.prepareStatement(studentName);
            studentStatement.setString(1, name);
            ResultSet setStudent = studentStatement.executeQuery();
            while (setStudent.next()){
                int id = setStudent.getInt(1);
                String student = setStudent.getString(2);
                System.out.println("Cтудент №" + id + " " + student);
            }
            studentStatement.execute();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
