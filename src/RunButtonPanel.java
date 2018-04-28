import javax.swing.*;
import java.awt.*;

public class RunButtonPanel extends JPanel {
    JButton Run;
    public RunButtonPanel(){
        setPreferredSize(new Dimension(100 , 200));
        Run = new JButton("Run");
        Run.setPreferredSize(new Dimension(100,100));
        add(Run);
    }
}
