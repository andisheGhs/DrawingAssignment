import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShapePropertiesPanel extends JPanel{
    PaintPanel paintPanel;
    Shape shape;
    JLabel xLable = new JLabel("X : ");
    JLabel yLable = new JLabel("Y : ");
    JTextField xTextField = new JTextField();
    JTextField yTextField = new JTextField();
    JLabel ColorLable = new JLabel("color : ");
    JButton colorChooserButton = new JButton("Choose a color");
    Color newColor = null;
    JButton applyButton = new JButton("apply");


    public ShapePropertiesPanel(Shape shape , PaintPanel paintPanel){
        this.shape = shape;
        this.paintPanel = paintPanel;
        setPreferredSize(new Dimension(400 , 200));
        setBackground(Color.PINK);
        initialize();
    }

    public void initialize(){
        this.setLayout(new GridLayout(0,2));
        xLable.setPreferredSize(new Dimension(200 , 100));
        yLable.setPreferredSize(new Dimension(200 ,100));
        xTextField.setPreferredSize(new Dimension(200 , 100));
        yTextField.setPreferredSize(new Dimension(200 ,100));
        ColorLable.setPreferredSize(new Dimension(200,100));
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apply();
            }
        });
        colorChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JColorChooser jcc = new JColorChooser();
//                add(jcc);
//                jcc.show();
//                newColor = jcc.getColor();
                newColor = JColorChooser.showDialog(null , "Choose a Color" , Color.red);
                if( newColor == null){
                    System.out.println("color null");
                }
            }
        });
        add(xLable);
        add(xTextField);
        add(yLable);
        add(yTextField);
        add(ColorLable);
        add(colorChooserButton);
        add(applyButton);
    }

    public void apply(){
        if ( shape != null ) {
            shape.setSolidColor(newColor);
            shape.setLocation(new Point(Double.parseDouble(xTextField.getText()), Double.parseDouble(yTextField.getText())));
            paintPanel.repaint();
        }
    }

}
