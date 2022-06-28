package org.example.ui;

import org.example.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {
    private final StudentService studentService;
    private final JButton record = new JButton("Записати");
    private final JButton search = new JButton("Пошук");
    private final JButton searchByName = new JButton("Пошук по імені");
    private final JButton update = new JButton("Изменить");

    Font font = new Font("Arial", Font.ITALIC, 15);
    JPanel panelMenu = new JPanel();

    public MenuWindow(StudentService studentService) {
        this.studentService = studentService;
        this.setTitle("Students");
        this.setBounds(10, 10, 500, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        record.setFont(font);
        search.setFont(font);
        searchByName.setFont(font);
        update.setFont(font);

        panelMenu.add(record);
        panelMenu.add(search);
        panelMenu.add(searchByName);
        panelMenu.add(update);

        this.add(panelMenu);
        ButtonsAction action = new ButtonsAction();
        record.addActionListener(action);
        search.addActionListener(action);
        searchByName.addActionListener(action);
        update.addActionListener(action);
    }

    class ButtonsAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == record) {
                new RecordWindow(studentService);
            }
            if (e.getSource() == search) {
                new OutputWindow(studentService);
            }
            if (e.getSource() == searchByName){
                new SearchWindow(studentService);
            }
            if (e.getSource() == update){
                new UpdateWindow(studentService);
            }
        }
    }
}


