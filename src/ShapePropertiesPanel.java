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
    JLabel empty = new JLabel("  ");
    JLabel radiusLabel = new JLabel("Radius");
    JTextArea radiusTextArea = new JTextArea();
    JLabel heightLabel = new JLabel("Height : ");
    JLabel widthLabel = new JLabel("Width : ");
    JTextArea HeightTextArea = new JTextArea();
    JTextArea WidthTextArea = new JTextArea();
    JLabel lineLabel = new JLabel("Transfer Vector : ");
    JTextArea LineTextArea = new JTextArea();

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
        radiusLabel.setPreferredSize(new Dimension(200,100));
        radiusTextArea.setPreferredSize(new Dimension(200,100));
        widthLabel.setPreferredSize(new Dimension(200,100));
        WidthTextArea.setPreferredSize(new Dimension(200,100));
        heightLabel.setPreferredSize(new Dimension(200,100));
        HeightTextArea.setPreferredSize(new Dimension(200,100));
        LineTextArea.setPreferredSize(new Dimension(200,100));
        lineLabel.setPreferredSize(new Dimension(200,100));



        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apply();
            }
        });
        colorChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        add(lineLabel);
        add(LineTextArea);
        add(radiusLabel);
        add(radiusTextArea);
        add(widthLabel);
        add(WidthTextArea);
        add(heightLabel);
        add(HeightTextArea);
        add(applyButton);
        add(empty);
    }


    public void apply(){
        if ( shape != null ) {
            shape.setSolidColor(newColor);
            shape.setLocation(new Point(Double.parseDouble(xTextField.getText()), Double.parseDouble(yTextField.getText())));
            if ( shape instanceof Circle ){
                ((Circle) shape).setRadius(Double.parseDouble(radiusTextArea.getText()));
            }
            if ( shape instanceof Line ){
                // TODO: 4/28/2018  
            }
            if ( shape instanceof Rectangle ){
                ((Rectangle) shape).setHeight(Double.parseDouble(HeightTextArea.getText()));
                ((Rectangle) shape).setWidth(Double.parseDouble(WidthTextArea.getText()));
            }
            paintPanel.repaint();
        }
    }

}
