import javax.swing.*;
import java.awt.*;

public class Service {
    private int activePlayer = 0;
    private int count = 0;
    private int fieldUL, fieldUM, fieldUR;
    private int fieldML, fieldMM, fieldMR;
    private int fieldDL, fieldDM, fieldDR;
    JFrame frame;
    Fields fields = new Fields();
    Service service = new Service();

    public void start() {
        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setBackground(new Color(255, 255, 255));
        frame.setContentPane(fields);
        frame.setVisible(false);
        frame.setVisible(true);
    }

    public void game(int field){
        count ++;
        if (count%2 == 0){
            activePlayer = 2;
        } else {
            activePlayer = 1;
        }

        System.out.println("ActivePlayer = " + activePlayer + " auf dem Feld: " + field);
        //service.setImage(field);

    }

    public void setImage(int field){
        Image XImage = new ImageIcon("src/images/X.png").getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        Image OImage = new ImageIcon("src/images/O.png").getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        fields.fieldUL.setIcon(new ImageIcon(XImage));
    }
}
