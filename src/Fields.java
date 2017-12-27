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
    Image WhiteImage = new ImageIcon("src/images/White.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    Image XImage     = new ImageIcon("src/images/X.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    Image OImage     = new ImageIcon("src/images/O.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    private Service service;

    public Fields(){
        service = new Service();
        this.setLayout(new GridLayout(3,3));
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

            if (button == fieldUL) {
                if (fieldUL.getIcon().equals("javax.swing.ImageIcon@2d85df5c")) {
                setImage(1);
                service.game(1);
                }
            }
            if (button == fieldUM) {
                setImage(2);
                service.game(2);
            }
            if (button == fieldUR) {
                setImage(3);
                service.game(3);
            }
            if (button == fieldML) {
                setImage(4);
                service.game(4);
            }
            if (button == fieldMM) {
                setImage(5);
                service.game(5);
            }
            if (button == fieldMR) {
                setImage(6);
                service.game(6);
            }
            if (button == fieldDL) {
                setImage(7);
                service.game(7);
            }
            if (button == fieldDM) {
                setImage(8);
                service.game(8);
            }
            if (button == fieldDR) {
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
                    break;
                case 2:
                    fieldUM.setIcon(new ImageIcon(OImage));
                    break;
                case 3:
                    fieldUR.setIcon(new ImageIcon(OImage));
                    break;
                case 4:
                    fieldML.setIcon(new ImageIcon(OImage));
                    break;
                case 5:
                    fieldMM.setIcon(new ImageIcon(OImage));
                    break;
                case 6:
                    fieldMR.setIcon(new ImageIcon(OImage));
                    break;
                case 7:
                    fieldDL.setIcon(new ImageIcon(OImage));
                    break;
                case 8:
                    fieldDM.setIcon(new ImageIcon(OImage));
                    break;
                case 9:
                    fieldDR.setIcon(new ImageIcon(OImage));
                    break;
                default:
                    System.out.println("Fehler bei Spieler 2");
            }
        } else {
            switch (field){
                case 1:
                    fieldUL.setIcon(new ImageIcon(XImage));
                    break;
                case 2:
                    fieldUM.setIcon(new ImageIcon(XImage));
                    break;
                case 3:
                    fieldUR.setIcon(new ImageIcon(XImage));
                    break;
                case 4:
                    fieldML.setIcon(new ImageIcon(XImage));
                    break;
                case 5:
                    fieldMM.setIcon(new ImageIcon(XImage));
                    break;
                case 6:
                    fieldMR.setIcon(new ImageIcon(XImage));
                    break;
                case 7:
                    fieldDL.setIcon(new ImageIcon(XImage));
                    break;
                case 8:
                    fieldDM.setIcon(new ImageIcon(XImage));
                    break;
                case 9:
                    fieldDR.setIcon(new ImageIcon(XImage));
                    break;
                default:
                    System.out.println("Fehler bei Spieler 1");
            }
        }

    }

}
