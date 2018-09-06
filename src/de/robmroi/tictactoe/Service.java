package de.robmroi.tictactoe;

import javax.swing.*;
import java.awt.*;


class Service {
    private int activePlayer;
    private boolean fieldCheck;
    int count;
    private int winner;
    private int theFields[] = new int[9];
    private JFrame frame;
    private int screenLength = Toolkit.getDefaultToolkit().getScreenSize().width;
    private Fields fields = new Fields();

    void preStart() {
        setFrame();
        fields.preStart();
        start();
    }

    private void setFrame(){
        //sets the size of the field, depending on the resolution of the screen
        double size = 40;
        double maxLengthDouble = Math.sqrt(screenLength);
        double lengthDouble = (maxLengthDouble / 3) * size;
        int length = (int) lengthDouble;
        //frame settings
        frame = new JFrame("TictacToe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(length, length));
        frame.setBackground(new Color(255, 255, 255));
        frame.setLocationRelativeTo(null);
    }


    private void start() {
        winner = 0;
        activePlayer = 0;
        count = 1;
        for (int i=0;i<theFields.length;i++) {
                theFields[i] = 0;
        }
        fieldCheck = false;

        fields.start();
        frame.setContentPane(fields);
        frame.setVisible(false);
        frame.setVisible(true);
    }

    void game(int field){
        if (count%2 == 0){
            activePlayer = 1;
        } else {
            activePlayer = 2;
        }
        count ++;
        System.out.println("Spieler " + activePlayer + " ist auf dem Feld: " + field + ".");
        theFields[field-1] = activePlayer;
        fieldCheck = true;
        for (int theField : theFields) {
            if (theField == 0) fieldCheck = false;
        }
        if (playerWin(activePlayer)) {
            winner =  activePlayer;
            winOutput("Spieler " + winner + " hat gewonnen!\n");
        } else if (!playerWin(1) && !playerWin(2) && fieldCheck) {
            winOutput("Es ist unentschieden! \n");
        }
    }

    private boolean playerWin(int player){
        if (theFields[0] == player && theFields[1] == player && theFields[2] == player) return true;
        else if (theFields[3] == player && theFields[4] == player && theFields[5] == player) return true;
        else if (theFields[6] == player && theFields[7] == player && theFields[8] == player) return true;
        else if (theFields[0] == player && theFields[3] == player && theFields[6] == player) return true;
        else if (theFields[1] == player && theFields[4] == player && theFields[7] == player) return true;
        else if (theFields[2] == player && theFields[5] == player && theFields[8] == player) return true;
        else if (theFields[0] == player && theFields[4] == player && theFields[8] == player) return true;
        else return theFields[2] == player && theFields[4] == player && theFields[6] == player;
    }
    private void winOutput(String text) {
        String newGame = "Wollen Sie noch eine Runde spielen?";
        int restartInt = JOptionPane.showConfirmDialog(null, text + newGame);
        if (restartInt == 0) {
            System.out.println("Neustart");
            start();
        } else {
            System.exit(0);
        }
    }



}
