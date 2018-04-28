import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    AnimationMenuPanel animationMenuPanel;
    AnimationToolsPanel animationToolsPanel;
    ShapePropertiesPanel shapePropertiesPanel;
    ShapePanel shapePanel;
    PaintPanel paintPanel;
    JPanel MixPanel;
    JPanel runButtonPanel;
    public MainFrame(){
        initialize();
    }
    public void initialize(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(1500 , 1200));
        setLayout(new BorderLayout());
        animationMenuPanel = new AnimationMenuPanel();
        shapePanel = new ShapePanel();
        paintPanel = (PaintPanel) ((ShapePanel) shapePanel).getPaintPanel();
        animationToolsPanel = new AnimationToolsPanel(paintPanel);
        shapePropertiesPanel = paintPanel.shapePropertiesPanel;
        runButtonPanel = paintPanel.runButtonPanel;
        MixPanel = new JPanel();
        MixPanel.setPreferredSize(new Dimension(1000 , 200));
        MixPanel.add(animationMenuPanel);
        MixPanel.add(shapePropertiesPanel);
        MixPanel.add(runButtonPanel);
        getContentPane().add(MixPanel , BorderLayout.SOUTH);
        getContentPane().add(paintPanel, BorderLayout.CENTER);
        getContentPane().add(animationToolsPanel , BorderLayout.WEST);
        getContentPane().add(shapePanel , BorderLayout.EAST);

        pack();

        setVisible(true);
    }
}
