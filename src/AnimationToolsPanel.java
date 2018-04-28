import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationToolsPanel extends JPanel {
     PaintPanel paintPanel;
    Shape selectedShape;
    JButton resizeButton = new JButton("Resize");
    JButton moveButton = new JButton("Move");
    JButton ShuffleButton = new JButton("Shuffle");
    public void setSelectedShape(PaintPanel paintPanel){
        selectedShape = paintPanel.previousSelectedShape;
    }
    public AnimationToolsPanel(PaintPanel paintPanel){
        this.paintPanel = paintPanel;
        setPreferredSize(new Dimension(200 , 700));
        setBackground(Color.pink);
        resizeButton.setPreferredSize(new Dimension(200 , 150));
        resizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedShape(paintPanel);
                ResizeAnimation resizeAnimation = new ResizeAnimation(1);
                resizeAnimation.shape = selectedShape;
                resizeAnimation.paintPanel = paintPanel;
                selectedShape.addAnimation(resizeAnimation);
            }
        });

        moveButton.setPreferredSize(new Dimension(200 , 150));
        ShuffleButton.setPreferredSize(new Dimension(200 , 150));
        add(resizeButton);
        add(moveButton);
        add(ShuffleButton);
    }
}
