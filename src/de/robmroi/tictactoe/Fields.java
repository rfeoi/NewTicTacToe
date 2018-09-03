package de.robmroi.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static de.robmroi.tictactoe.Startup.service;

public class Fields extends JPanel {
    /* field + Position
        U = Up      L = Left
        M = Mid     M = Mid
        D = Down    R = Right
    */

     JButton fieldUL = new JButton();
     JButton fieldUM = new JButton();
     JButton fieldUR = new JButton();
     JButton fieldML = new JButton();
     JButton fieldMM = new JButton();
     JButton fieldMR = new JButton();
     JButton fieldDL = new JButton();
     JButton fieldDM = new JButton();
     JButton fieldDR = new JButton();
     boolean one, two, three, four, five, six, seven, eight, nine;
    Image WhiteImage = new ImageIcon("src/images/White.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    Image XImage     = new ImageIcon("src/images/X.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    Image OImage     = new ImageIcon("src/images/O.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

    public void preStart(){
        this.setLayout(new GridLayout(3,3));

        this.add(fieldUL);
        this.add(fieldUM);
        this.add(fieldUR);
        this.add(fieldML);
        this.add(fieldMM);
        this.add(fieldMR);
        this.add(fieldDL);
        this.add(fieldDM);
        this.add(fieldDR);

        fieldUL.addActionListener(actionListener);
        fieldUM.addActionListener(actionListener);
        fieldUR.addActionListener(actionListener);
        fieldML.addActionListener(actionListener);
        fieldMM.addActionListener(actionListener);
        fieldMR.addActionListener(actionListener);
        fieldDL.addActionListener(actionListener);
        fieldDM.addActionListener(actionListener);
        fieldDR.addActionListener(actionListener);
    }


    public Fields(){
        fieldUL.setIcon(new ImageIcon(WhiteImage));
        fieldUM.setIcon(new ImageIcon(WhiteImage));
        fieldUR.setIcon(new ImageIcon(WhiteImage));
        fieldML.setIcon(new ImageIcon(WhiteImage));
        fieldMM.setIcon(new ImageIcon(WhiteImage));
        fieldMR.setIcon(new ImageIcon(WhiteImage));
        fieldDL.setIcon(new ImageIcon(WhiteImage));
        fieldDM.setIcon(new ImageIcon(WhiteImage));
        fieldDR.setIcon(new ImageIcon(WhiteImage));
        one = false;
        two = false;
        three = false;
        four = false;
        five = false;
        six = false;
        seven = false;
        eight = false;
        nine = false;
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!(e.getSource() instanceof JButton)) return;
            JButton button = (JButton) e.getSource();

            if (button == fieldUL && !one) {
                setImage(1);
                service.game(1);
            }
            if (button == fieldUM && !two) {
                setImage(2);
                service.game(2);
            }
            if (button == fieldUR && !three) {
                setImage(3);
                service.game(3);
            }
            if (button == fieldML && !four) {
                setImage(4);
                service.game(4);
            }
            if (button == fieldMM && !five) {
                setImage(5);
                service.game(5);
            }
            if (button == fieldMR && !six) {
                setImage(6);
                service.game(6);
            }
            if (button == fieldDL && !seven) {
                setImage(7);
                service.game(7);
            }
            if (button == fieldDM && !eight) {
                setImage(8);
                service.game(8);
            }
            if (button == fieldDR && !nine) {
                setImage(9);
                service.game(9);
            }
        }
    };

    public void setImage(int field){

        if (service.count%2 == 0){
            switch (field){
                case 1:
                    fieldUL.setIcon(new ImageIcon(OImage));
                    one = true;
                    break;
                case 2:
                    fieldUM.setIcon(new ImageIcon(OImage));
                    two = true;
                    break;
                case 3:
                    fieldUR.setIcon(new ImageIcon(OImage));
                    three = true;
                    break;
                case 4:
                    fieldML.setIcon(new ImageIcon(OImage));
                    four = true;
                    break;
                case 5:
                    fieldMM.setIcon(new ImageIcon(OImage));
                    five = true;
                    break;
                case 6:
                    fieldMR.setIcon(new ImageIcon(OImage));
                    six = true;
                    break;
                case 7:
                    fieldDL.setIcon(new ImageIcon(OImage));
                    seven = true;
                    break;
                case 8:
                    fieldDM.setIcon(new ImageIcon(OImage));
                    eight = true;
                    break;
                case 9:
                    fieldDR.setIcon(new ImageIcon(OImage));
                    nine = true;
                    break;
                default:
                    System.out.println("Fehler bei Spieler 2");
            }
        } else {
            switch (field){
                case 1:
                    fieldUL.setIcon(new ImageIcon(XImage));
                    one = true;
                    break;
                case 2:
                    fieldUM.setIcon(new ImageIcon(XImage));
                    two = true;
                    break;
                case 3:
                    fieldUR.setIcon(new ImageIcon(XImage));
                    three= true;
                    break;
                case 4:
                    fieldML.setIcon(new ImageIcon(XImage));
                    four = true;
                    break;
                case 5:
                    fieldMM.setIcon(new ImageIcon(XImage));
                    five = true;
                    break;
                case 6:
                    fieldMR.setIcon(new ImageIcon(XImage));
                    six = true;
                    break;
                case 7:
                    fieldDL.setIcon(new ImageIcon(XImage));
                    seven = true;
                    break;
                case 8:
                    fieldDM.setIcon(new ImageIcon(XImage));
                    eight = true;
                    break;
                case 9:
                    fieldDR.setIcon(new ImageIcon(XImage));
                    nine = true;
                    break;
                default:
                    System.out.println("Fehler bei Spieler 1");
            }
        }

    }

}
