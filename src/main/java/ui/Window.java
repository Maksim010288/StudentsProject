package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame {
   private JLabel record = new JLabel("Записати");
   private JLabel search = new JLabel("Пошук");
   private JPanel panelRecord, panelSearch, panelSearchByName;

    public Window(){
        this.setTitle("Window search");
        this.setBounds(40, 40, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.TRAILING);
        this.setLayout(flowLayout);

        this.add(record);
        this.add(search);

        WindowOpen windowOpen = new WindowOpen();
        record.addMouseListener(windowOpen);
    }

    public JPanel record(){
        panelRecord = new JPanel();
        panelRecord.setBounds(0, 30,200, 200);
        panelRecord.setBackground(Color.red);
        panelRecord.setVisible(true);
        return panelRecord;
    }

    class WindowOpen implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == record){
                record();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == record){
                record.setForeground(Color.red);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == record){
                record.setForeground(Color.black);
            }
        }
    }

    public static void main(String[] args) {
        new Window();
    }
}
