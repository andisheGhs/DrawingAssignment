import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationToolsPanel extends JPanel {
     PaintPanel paintPanel;
     AnimationMenuPanel animationMenuPanel;
    Shape selectedShape;
    JButton resizeButton = new JButton("Resize");
    JButton moveButton = new JButton("Move");
    JButton ShuffleButton = new JButton("Shuffle");
    public void setSelectedShape(PaintPanel paintPanel){
        selectedShape = paintPanel.previousSelectedShape;
//        System.out.println(paintPanel.selectedShape);
    }
    public AnimationToolsPanel(PaintPanel paintPanel , AnimationMenuPanel animationMenuPanel){
        this.animationMenuPanel = animationMenuPanel;
        animationMenuPanel.animationToolsPanel = this;
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
                resizeAnimation.animationMenuPanel = animationMenuPanel;
                if ( animationMenuPanel.numberTextArea.getText() != null) {
                    resizeAnimation.number = Integer.parseInt(animationMenuPanel.numberTextArea.getText());
                }
                selectedShape.addAnimation(resizeAnimation);
            }
        });

        moveButton.setPreferredSize(new Dimension(200 , 150));
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedShape(paintPanel);
                MoveAnimation moveAnimation = new MoveAnimation(1);
                moveAnimation.shape = selectedShape;
                moveAnimation.paintPanel = paintPanel;
                moveAnimation.animationMenuPanel = animationMenuPanel;
                moveAnimation.x = Double.parseDouble(animationMenuPanel.xTextArea.getText());
                moveAnimation.y = Double.parseDouble(animationMenuPanel.yTextArea.getText());
                selectedShape.addAnimation(moveAnimation);
            }
        });
        ShuffleButton.setPreferredSize(new Dimension(200 , 150));
        ShuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedShape(paintPanel);
                ShuffleAnimation shuffleAnimation = new ShuffleAnimation(100);
                shuffleAnimation.shape = (Image)selectedShape;
                shuffleAnimation.paintPanel = paintPanel;
                shuffleAnimation.animationMenuPanel = animationMenuPanel;
                shuffleAnimation.time = Integer.parseInt(animationMenuPanel.timeTextArea.getText());
                selectedShape.addAnimation(shuffleAnimation);
            }
        });
        add(resizeButton);
        add(moveButton);
        add(ShuffleButton);
    }
}
