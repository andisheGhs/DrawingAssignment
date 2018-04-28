import javax.swing.*;
import java.awt.*;

public class AnimationMenuPanel extends JPanel {

    JCheckBox isAnimatingCheckBox = new JCheckBox("animate mood");
    JCheckBox isChangingCheckBox = new JCheckBox("change mood");
    JCheckBox isRepeating = new JCheckBox(" Repeat mood");
    JTextArea xTextArea = new JTextArea();
    JTextArea yTextArea = new JTextArea();
    JLabel xLabel = new JLabel("X : ");
    JLabel yLabel = new JLabel("Y : ");
    public AnimationMenuPanel(){
        setPreferredSize(new Dimension(400 , 200));
        setBackground(Color.PINK);
        setLayout(new GridLayout(0 , 2));
        xTextArea.setPreferredSize(new Dimension(200 , 100));
        yTextArea.setPreferredSize(new Dimension(200 , 100));
        add(xLabel);
        add(xTextArea);
        add(yLabel);
        add(yTextArea);
        add(isAnimatingCheckBox);
        add(isRepeating);
        add(isChangingCheckBox);


    }
}
