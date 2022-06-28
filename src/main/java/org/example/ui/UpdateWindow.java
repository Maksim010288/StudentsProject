package org.example.ui;

import org.example.db.entity.StudentEntity;
import org.apache.log4j.Logger;
import org.example.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateWindow extends JFrame {
    Logger log = Logger.getLogger(UpdateWindow.class);
    StudentService studentService;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField courseField;
    private final JTextField idField;
    private final JButton update;

    public UpdateWindow(StudentService studentService) {
        this.studentService = studentService;
        this.setTitle("Update");
        this.setBounds(10, 120, 500, 120);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 4));
        JLabel id = new JLabel("ID");
        JLabel firstName = new JLabel("ІМЯ");
        JLabel lastName = new JLabel("ФАМІЛІЯ");
        JLabel course = new JLabel("КУРС");
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        courseField = new JTextField(2);
        idField = new JTextField(2);
        update = new JButton("Змінити");
        this.add(firstName);
        this.add(firstNameField);

        this.add(lastName);
        this.add(lastNameField);

        this.add(id);
        this.add(idField);

        this.add(course);
        this.add(courseField);
        this.add(update);

        this.setVisible(true);

        UpdateAction action = new UpdateAction();
        update.addActionListener(action);
    }

    class UpdateAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StudentEntity studentEntity = new StudentEntity(
                    Integer.parseInt(idField.getText()),
                    Integer.parseInt(courseField.getText()),
                    firstNameField.getText(),
                    lastNameField.getText());
            if (e.getSource() == update) {
                studentService.update(studentEntity);
                firstNameField.setText(null);
                lastNameField.setText(null);
                courseField.setText(null);
                idField.setText(null);
            }
        }
    }
}