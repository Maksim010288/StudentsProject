package ui;

import db.jdbc.StudentsDAO;
import dto.StudentDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class OutputWindow extends JFrame {
    StudentsDAO studentsDAO;
    JButton studentAll = new JButton("Вивести всіх студентів");
    JTextArea searchResult = new JTextArea(25, 45);
    Font font = new Font("Arial", Font.BOLD, 14);

    public OutputWindow(StudentsDAO studentsDAO) {
        this.studentsDAO = studentsDAO;

        this.setTitle("Пошук за імям");
        this.setBounds(10, 120, 500, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(studentAll);
        this.setResizable(false);
        searchResult.setFont(font);
        searchResult.setForeground(Color.blue);
        searchResult.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 0));
        this.add(searchResult);
        this.setVisible(true);

        StudentOutput output = new StudentOutput();
        studentAll.addActionListener(output);
    }

    class StudentOutput implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == studentAll && searchResult.getText().isEmpty()) {
                Collection<StudentDTO> students = studentsDAO.getStudents();
                int count = 0;
                for (StudentDTO s : students) {
                    count++;
                    searchResult.append(String.format("%3s) %15s %15s %15d course\n",
                            count,
                            s.getLastName(),
                            s.getFirstName(),
                            s.getCourse()));
                }
            }
        }
    }
}
