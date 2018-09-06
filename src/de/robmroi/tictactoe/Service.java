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
    private int maxWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int width;

    /*
    TODO
    - win check fixing
     */

    void preStart() {
        setFrame();
        start();
    }

    private void setFrame(){
        //sets the size of the field, depending on the resolution of the screen
        double size = 40;
        double maxWidthDouble = Math.sqrt(maxWidth);
        double widthDouble = (maxWidthDouble / 3) * size;
        width = (int) widthDouble;
        //frame settings
        frame = new JFrame("TictacToe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(width,width));
        frame.setBackground(new Color(255, 255, 255));
        frame.setLocationRelativeTo(null);
    }


    private void start() {
        Fields fields = new Fields();
        winner = 0;
        activePlayer = 0;
        count = 1;
        for (int i=0;i<3;i++) {
                theFields[i] = 0;
        }
        fieldCheck = false;

        fields.preStart();
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
