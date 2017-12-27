import javax.swing.*;
import java.awt.*;
import java.security.PrivateKey;

public class Service {
    private int activePlayer = 0;
    public int count = 1;
    private int fieldUL, fieldUM, fieldUR;
    private int fieldML, fieldMM, fieldMR;
    private int fieldDL, fieldDM, fieldDR;
    private Fields fields;
    JFrame frame;


    public void start() {
        fields = new Fields();
        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setBackground(new Color(255, 255, 255));
        frame.setContentPane(fields);
        frame.setVisible(false);
        frame.setVisible(true);
    }

    public void game(int field){

        if (count%2 == 0){
            activePlayer = 2;
        } else {
            activePlayer = 1;
        }
        count ++;
        System.out.println("ActivePlayer = " + activePlayer + " auf dem Feld: " + field);

    }


}
