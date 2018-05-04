import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class RunButtonPanel extends JPanel {
    boolean isInAnimatingMood = true;
    JButton Run;
    Thread thread;
    ArrayList<Shape> shapes = new ArrayList<>();
    public RunButtonPanel(){
        setPreferredSize(new Dimension(100 , 200));
        Run = new JButton("Run");
        Run.setPreferredSize(new Dimension(100,100));
        add(Run);
        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( thread != null && thread.isAlive() ){
                    thread.interrupt();
                } else {
                    newThread();
                }
            }
        });
    }
    public void newThread(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!thread.currentThread().isInterrupted()) {
                    Iterator<Shape> cur = shapes.iterator();
                    while (cur.hasNext()) {
                        Shape shape = cur.next();
                        shape.step();
                    }
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });
        thread.start();
    }
}
