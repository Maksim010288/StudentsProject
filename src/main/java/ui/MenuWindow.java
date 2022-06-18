package ui;

import db.jdbc.StudentsDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {
    StudentsDAO studentsDAO;
    private final JButton record = new JButton("Записати");
    private final JButton search = new JButton("Пошук");
    private final JButton searchByName = new JButton("Пошук по імені");

    Font font = new Font("Arial", Font.ITALIC, 15);
    JPanel panelMenu = new JPanel();

    public MenuWindow(StudentsDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
        this.setTitle("Students");
        this.setBounds(10, 10, 500, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        record.setFont(font);
        search.setFont(font);
        searchByName.setFont(font);

        panelMenu.add(record);
        panelMenu.add(search);
        panelMenu.add(searchByName);

        this.add(panelMenu);
        ButtonsAction action = new ButtonsAction();
        record.addActionListener(action);
        search.addActionListener(action);
        searchByName.addActionListener(action);
    }

    class ButtonsAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == record) {
                new RecordWindow(studentsDAO);
            }
            if (e.getSource() == search) {
                new OutputWindow(studentsDAO);
            }
            if (e.getSource() == searchByName){
                new SearchWindow(studentsDAO);
            }
        }
    }
}


