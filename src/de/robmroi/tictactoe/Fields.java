package de.robmroi.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import static de.robmroi.tictactoe.Startup.service;

class Fields extends JPanel {
     private JButton[] fields = new JButton[9];
     private boolean[] checking = new boolean[9];
    private Image XImage = new ImageIcon("src/images/X.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    private Image OImage = new ImageIcon("src/images/O.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

    void preStart(){
        this.setLayout(new GridLayout(3,3));

        for (int i=0;i<fields.length;i++) {
            fields[i] = new JButton();
            this.add(fields[i]);
            fields[i].addActionListener(actionListener);
        }
    }


    void start(){
        Image whiteImage = new ImageIcon("src/images/White.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        for (int i=0;i<9;i++){
            fields[i].setIcon(new ImageIcon(whiteImage));
            checking[i] = false;
        }
    }

    private ActionListener actionListener = e -> {
        if (!(e.getSource() instanceof JButton)) return;
        JButton button = (JButton) e.getSource();

        for (int i=0;i<fields.length;i++){
            if (button == fields[i] && !checking[i]) {
                setImage(i+1);
                service.game(i+1);
            }
        }
    };

    private void setImage(int field){
        if (service.count%2 == 0) {
            fields[field-1].setIcon(new ImageIcon(OImage));
            checking[field-1] = true;
        } else {
            fields[field-1].setIcon(new ImageIcon(XImage));
            checking[field-1] = true;
        }
    }

}
