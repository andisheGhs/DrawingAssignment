import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class RunButtonPanel extends JPanel {
    JButton Run;
    ArrayList<Shape> shapes = new ArrayList<>();
    public RunButtonPanel(){
        setPreferredSize(new Dimension(100 , 200));
        Run = new JButton("Run");
        Run.setPreferredSize(new Dimension(100,100));
        add(Run);
        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Iterator<Shape> cur = shapes.iterator();
                while( cur.hasNext() ){
                    Shape shape = cur.next();
                    shape.step();
                }
            }
        });
    }
}
