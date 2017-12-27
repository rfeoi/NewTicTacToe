import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restart extends JPanel {
    private MyJButton neustart;
    private JLabel winnerLabel;
    private Service service;

    public Restart(){
        winnerLabel = new JLabel("Spieler " + service.winner + " hat gewonnen!");
        service = new Service();
        neustart = new MyJButton("Neustart");
        this.setLayout(new GridLayout(2,1));
        this.add(winnerLabel);
        this.add(neustart);
        neustart.addActionListener(actionListener);
    }


    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!(e.getSource() instanceof JButton)) return;
            JButton button = (JButton) e.getSource();
            if (button.getText().equals(neustart.getText())) service.start();
        }
    };

}
