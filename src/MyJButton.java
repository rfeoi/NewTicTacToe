import javax.swing.*;
import java.awt.*;

/**
 * Own JButton
 * Created by felix on 29.10.2017.
 */
public class MyJButton extends JButton {
     public MyJButton(String text){
        super(text);
        Font font = new Font("Arial", Font.PLAIN, 40);
        this.setFont(font);
    }

}
