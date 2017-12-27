import javax.swing.*;
import java.awt.*;
import java.security.PrivateKey;

public class Service {
    private int activePlayer;
    public int count, winner;
    private int fieldUL, fieldUM, fieldUR;
    private int fieldML, fieldMM, fieldMR;
    private int fieldDL, fieldDM, fieldDR;
    private Fields fields;
    private Restart restart;
    JFrame frame;

    public void preStart() {
        fields = new Fields();
        restart = new Restart();
        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setBackground(new Color(255, 255, 255));
        start();
    }


    public void start() {
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

        if (playerWin(activePlayer)) {
            winner =  activePlayer;
            frame.setContentPane(restart);
            frame.setVisible(false);
            frame.setVisible(true);
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



}
