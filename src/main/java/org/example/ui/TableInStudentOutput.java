package org.example.ui;

import org.example.db.entity.StudentEntity;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class TableInStudentOutput extends JFrame {

    JTable table;

    public TableInStudentOutput() {
        this.setSize(new Dimension(500, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        table();
        this.add(table);
        this.setVisible(true);
    }

    public void table() {
        List<StudentEntity> collection = new LinkedList<>();
        collection.add(new StudentEntity(1, 2, "Martin", "Bob"));
        collection.add(new StudentEntity(2, 4, "Zadornow", "Serhiy"));
        collection.add(new StudentEntity(1, 2, "Baranow", "Andrey"));
        collection.add(new StudentEntity(1, 2, "Koliuhiy", "Denis"));
        String[] header = {"id", "course", "Имя", "Фамилия"};
        String[][] output = new String[4][4];
        int i = 0;
        for (StudentEntity entity : collection) {
            output[i][0] = String.valueOf(entity.getId());
            output[i][1] = String.valueOf(entity.getCourse());
            output[i][2] = entity.getFirstName();
            output[i][3] = entity.getLastName();
            i++;
        }
        table = new JTable(output, header);
        //table.setBounds(10, 10, 500, 400);
       // table.setFillsViewportHeight(true);
    }

    public static void main(String[] args) {
        new TableInStudentOutput();
    }
}
