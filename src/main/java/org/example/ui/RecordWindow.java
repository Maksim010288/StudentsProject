package org.example.ui;

import org.example.service.StudentService;
import org.example.service.dto.StudentDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordWindow extends JFrame {
    StudentService studentService;

    protected JLabel firstName = new JLabel("Імя");
    protected JLabel lastName = new JLabel("Фамілія");
    protected JLabel course = new JLabel("Курс");
    protected JLabel message = new JLabel();

    protected JTextField firstNameField = new JTextField(20);
    protected JTextField lastNameField = new JTextField(20);
    protected JTextField courseField = new JTextField(2);

    protected JButton record = new JButton("Записати");

    public RecordWindow(StudentService studentService) {
        this.studentService = studentService;
        this.setTitle("Record");
        this.setBounds(10, 120, 500, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        JPanel records = new JPanel();
        records.setLayout(new BoxLayout(records, BoxLayout.PAGE_AXIS));

        records.add(firstName);
        records.add(firstNameField);
        records.add(lastName);
        records.add(lastNameField);
        records.add(course);
        records.add(courseField);
        records.add(record);
        records.add(message);
        message.setForeground(Color.red);
        records.setVisible(true);

        RecordListener recordListener = new RecordListener();
        record.addActionListener(recordListener);
        this.add(records);
    }

    class RecordListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StudentDTO student = new StudentDTO(firstNameField.getText(), lastNameField.getText(),
                    Integer.parseInt(courseField.getText()));
            if (e.getSource() == record) {
                studentService.create(student);
                lastNameField.setText(null);
                firstNameField.setText(null);
                courseField.setText(null);
                message.setText("Запис створено!!!");
            }
        }
    }
}

