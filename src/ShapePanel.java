import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel {
    PaintPanel paintPanel;
    JButton circleButton;
    JButton TriangleButton;
    JButton RectangleButton;
    JButton LineButton;

    public JPanel getPaintPanel() {
        return paintPanel;
    }

    public void setPaintPanel(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

    public ShapePanel(){
        setPreferredSize(new Dimension(200 , 700));
        setBackground(Color.pink);
        circleButton = new JButton("Circle");
        TriangleButton = new JButton("Triangle");
        RectangleButton = new JButton("Rectangle");
        LineButton = new JButton("Line");
        paintPanel = new PaintPanel();
        LineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Line line = new Line(new Point(300, 125 ) , new Point(400 , 100) , new Point(200 , 150));
                paintPanel.addShape(line);
                paintPanel.repaint();
            }
        });
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circle circle = new Circle(new Point(400 , 400) , 100);
                paintPanel.addShape(circle);
                paintPanel.repaint();
            }
        });
        TriangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Triangle triangle = new Triangle(new Point(400 , 500) , new Point(500 , 500) , new Point(450 , 300));
                paintPanel.addShape(triangle);
                paintPanel.repaint();
            }
        });
        RectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rectangle = new Rectangle(new Point(400 , 400) , 100 , 100);
                paintPanel.addShape(rectangle);
                paintPanel.repaint();
            }
        });


        LineButton.setPreferredSize(new Dimension(200 , 150));
        circleButton.setPreferredSize(new Dimension(200 , 150));
        TriangleButton.setPreferredSize(new Dimension(200 , 150));
        RectangleButton.setPreferredSize(new Dimension(200 , 150));
        add(circleButton);
//        add(TriangleButton);
        add(RectangleButton);
        add(LineButton);
    }


}
