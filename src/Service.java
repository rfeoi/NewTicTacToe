import javax.swing.*;
import java.awt.*;

public class Service {
    private int activePlayer, restartInt;
    private boolean fieldCheck;
    public int count, winner;
    private int fieldUL, fieldUM, fieldUR;
    private int fieldML, fieldMM, fieldMR;
    private int fieldDL, fieldDM, fieldDR;
    private Fields fields;
    JFrame frame;

    public void preStart() {
        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setBackground(new Color(255, 255, 255));
        start();
    }


    public void start() {
        fields = new Fields();
        winner = 0;
        activePlayer = 0;
        count = 1;
        fieldUL = 0;
        fieldUM = 0;
        fieldUR = 0;
        fieldML = 0;
        fieldMM = 0;
        fieldMR = 0;
        fieldDL = 0;
        fieldDM = 0;
        fieldDR = 0;
        fieldCheck = false;

        fields.preStart();
        frame.setContentPane(fields);
        frame.setVisible(false);
        frame.setVisible(true);
    }

    public void game(int field){
        if (count%2 == 0){
            activePlayer = 1;
        } else {
            activePlayer = 2;
        }
        count ++;
        System.out.println("Spieler " + activePlayer + " ist auf dem Feld: " + field + ".");
        if (field == 1) fieldUL = activePlayer;
        if (field == 2) fieldUM = activePlayer;
        if (field == 3) fieldUR = activePlayer;
        if (field == 4) fieldML = activePlayer;
        if (field == 5) fieldMM = activePlayer;
        if (field == 6) fieldMR = activePlayer;
        if (field == 7) fieldDL = activePlayer;
        if (field == 8) fieldDM = activePlayer;
        if (field == 9) fieldDR = activePlayer;
        if(fieldUL != 0 && fieldUM != 0 && fieldUR != 0 && fieldML != 0 && fieldMM != 0 && fieldMR != 0 && fieldDL != 0 && fieldDM != 0 && fieldDR != 0){
          fieldCheck = true;
        }

        if (playerWin(activePlayer)) {
            winner =  activePlayer;
            winOutput("Spieler " + winner + " hat gewonnen!\n");
        } else if (!playerWin(1) && !playerWin(2) && fieldCheck) {
            winOutput("Es ist unentschieden! \n");
        }


    }

    public boolean playerWin(int player){
        if (fieldUL == player && fieldUM == player && fieldUR == player) {
            return true;
        } else if (fieldML == player && fieldMM == player && fieldMR == player) {
            return true;
        } else if (fieldDL == player && fieldDM == player && fieldDR == player) {
            return true;
        } else if (fieldUL == player && fieldML == player && fieldDL == player) {
            return true;
        } else if (fieldUM == player && fieldMM == player && fieldDM == player) {
            return true;
        } else if (fieldUR == player && fieldMR == player && fieldDR == player) {
            return true;
        } else if (fieldUL == player && fieldMM == player && fieldDR == player) {
            return true;
        } else if (fieldDL == player && fieldMM == player && fieldUR == player) {
            return true;
        } else {
            return false;
        }
    }
    public void winOutput(String text) {
        String newGame = "Wollen Sie noch eine Runde spielen?";
        restartInt = JOptionPane.showConfirmDialog(null, text + newGame);
        if (restartInt == 0) {
            System.out.println("Neustart");
            start(); // <- Hier wirft er den Fehler auf
        } else {
            System.exit(0);
        }
    }



}
