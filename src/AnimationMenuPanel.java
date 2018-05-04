import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationMenuPanel extends JPanel {
    AnimationToolsPanel animationToolsPanel;
    Shape selectedShape = null;
    boolean isInRepeatMood = false ;
    boolean isInAnimatingMood = false;
    JButton addPictureButton = new JButton("add a picture");
    JCheckBox isAnimatingCheckBox = new JCheckBox("animate mood");
    JCheckBox isRepeating = new JCheckBox(" Repeat mood");
    JTextArea xTextArea = new JTextArea();
    JTextArea yTextArea = new JTextArea();
    JTextArea timeTextArea = new JTextArea("Time");
    JLabel xLabel = new JLabel("X : ");
    JLabel yLabel = new JLabel("Y : ");
    JLabel numberLabel = new JLabel("Enter a resize number : ");
    JTextArea numberTextArea = new JTextArea();
    public AnimationMenuPanel(){
        setPreferredSize(new Dimension(400 , 200));
        setBackground(Color.PINK);
        setLayout(new GridLayout(0 , 2));
        xTextArea.setPreferredSize(new Dimension(200 , 100));
        yTextArea.setPreferredSize(new Dimension(200 , 100));
        timeTextArea.setPreferredSize(new Dimension(200  , 100));
        numberLabel.setPreferredSize(new Dimension(200 , 100));
        numberTextArea.setPreferredSize(new Dimension(200 , 100));
        addPictureButton.setPreferredSize(new Dimension(200 , 100));
        isAnimatingCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isInAnimatingMood = !isInAnimatingMood;
            }
        });
        isRepeating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isInRepeatMood = !isInRepeatMood;
            }
        });
        addPictureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animationToolsPanel.setSelectedShape(animationToolsPanel.paintPanel);
                selectedShape = animationToolsPanel.selectedShape;
                System.out.println(animationToolsPanel);
                System.out.println(animationToolsPanel.selectedShape);
                System.out.println(selectedShape);
                if ( selectedShape instanceof  Image ){
                    System.out.println("here");
                    ((Image) selectedShape).addImage();
                }
            }
        });

        add(isAnimatingCheckBox);
        add(isRepeating);
        add(xLabel);
        add(xTextArea);
        add(yLabel);
        add(yTextArea);
        add(numberLabel);
        add(numberTextArea);
        add(addPictureButton);
        add(timeTextArea);
    }
}
