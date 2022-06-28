package org.example.ui;

import org.example.service.StudentService;
import org.example.service.dto.StudentDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class OutputWindow extends JFrame {
    private final StudentService studentService;
    private final JTextArea outputTextField;
    private DefaultTableModel tableModel;
    private final JTable jTable;
    private final JButton studentAll = new JButton("Вивести всіх студентів");
    private final Font font = new Font("Arial", Font.BOLD, 14);

    public OutputWindow(StudentService studentService) {
        this.studentService = studentService;
        outputTextField = new JTextArea(40, 40);
        outputTextField.setFont(font);
        outputTextField.setForeground(Color.blue);
        outputTextField.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 0));
        tableModel = new DefaultTableModel(0, 4);
        jTable = new JTable(tableModel);
        this.setTitle("Пошук за імям");
        this.setBounds(10, 120, 500, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(studentAll);
        this.setResizable(false);
        this.add(jTable);
        this.setVisible(true);

        StudentOutput output = new StudentOutput();
        studentAll.addActionListener(output);
    }

    class StudentOutput implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == studentAll) {
                tableModel.setRowCount(0);
                Collection<StudentDTO> students = studentService.getStudents();
                int count = 0;
                for (StudentDTO entity : students) {
                    tableModel.insertRow(count, new String[] {
                            String.valueOf(count+1),
                            entity.getFirstName(),
                            entity.getLastName(),
                            String.valueOf(entity.getCourse())
                    });
                    count++;
                }
            }
        }
    }
}
