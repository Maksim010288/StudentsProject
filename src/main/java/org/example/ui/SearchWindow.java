package org.example.ui;

import org.example.service.StudentService;
import org.example.service.dto.StudentDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class SearchWindow extends JFrame {
    StudentService studentService;
    JLabel label = new JLabel("Введіть імя");
    JTextField field = new JTextField(20);
    JButton button = new JButton("Пошук");
    JTextArea outLabel = new JTextArea(20, 20);

    public SearchWindow(StudentService studentService) {
        this.studentService = studentService;
        this.setTitle("пошук по імені");
        this.setBounds(10, 90, 500, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(label);
        this.add(field);
        this.add(button);
        this.add(outLabel);
        this.setVisible(true);

        SearchByName search = new SearchByName();
        button.addActionListener(search);
    }

    class SearchByName implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Collection<StudentDTO> students = studentService.findByFirstName(field.getText());
            if (e.getSource() == button) {
                field.setText(null);
                outLabel.setText(null);
                for (StudentDTO s : students) {
                    outLabel.append(String.format("%s. %s %s\n",
                            s.getId(),
                            s.getFirstName(),
                            s.getLastName()));
                }
            }
        }
    }
}
