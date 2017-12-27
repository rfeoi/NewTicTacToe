import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fields extends JPanel {
    /* field + Position
        U = Up      L = Left
        M = Mid     M = Mid
        D = Down    R = Right
    */

    public JButton fieldUL = new JButton();
    public JButton fieldUM = new JButton();
    public JButton fieldUR = new JButton();
    public JButton fieldML = new JButton();
    public JButton fieldMM = new JButton();
    public JButton fieldMR = new JButton();
    public JButton fieldDL = new JButton();
    public JButton fieldDM = new JButton();
    public JButton fieldDR = new JButton();
    private Service service;

    public Fields(){
        service = new Service();
        this.setLayout(new GridLayout(3,3));
        Image WhiteImage = new ImageIcon("src/images/White.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        fieldUL.setIcon(new ImageIcon(WhiteImage));
        fieldUM.setIcon(new ImageIcon(WhiteImage));
        fieldUR.setIcon(new ImageIcon(WhiteImage));
        fieldML.setIcon(new ImageIcon(WhiteImage));
        fieldMM.setIcon(new ImageIcon(WhiteImage));
        fieldMR.setIcon(new ImageIcon(WhiteImage));
        fieldDL.setIcon(new ImageIcon(WhiteImage));
        fieldDM.setIcon(new ImageIcon(WhiteImage));
        fieldDR.setIcon(new ImageIcon(WhiteImage));


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
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!(e.getSource() instanceof JButton)) return;
            JButton button = (JButton) e.getSource();

            if (button == fieldUL) service.game(1);
            if (button == fieldUM) service.game(2);
            if (button == fieldUR) service.game(3);
            if (button == fieldML) service.game(4);
            if (button == fieldMM) service.game(5);
            if (button == fieldMR) service.game(6);
            if (button == fieldDL) service.game(7);
            if (button == fieldDM) service.game(8);
            if (button == fieldDR) service.game(9);
        }
    };

}
