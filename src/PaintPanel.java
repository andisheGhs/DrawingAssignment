import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class PaintPanel extends JPanel {
    RunButtonPanel runButtonPanel = new RunButtonPanel();
    ArrayList<Shape> shapes = new ArrayList<>();
    Point previousMouseLocation = null;
    Shape selectedShape = null;
    Shape previousSelectedShape = null;
    Thread animationThread = null;
    boolean animating;
    ShapePropertiesPanel shapePropertiesPanel = new ShapePropertiesPanel(selectedShape , this);

    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }

    public boolean isAnimating() {
        return animating;
    }

    public void setAnimating(boolean animating) {
        this.animating = animating;
    }

    public void clearShapes(){
        shapes.clear();
    }

    public void addShape(Shape shape ){
        shapes.add(shape);
//        shapePropertiesPanel.addPanel(shape.getPropertiesPanel());
    }

    public PaintPanel(){
        initialize();
    }

    void initialize(){
//        System.out.println("running paintpanel");
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.GRAY);
        runButtonPanel.shapes = this.shapes;
        animating=false;

        animationThread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(animating==false) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }

                    Iterator<Shape> iterator=shapes.iterator();
                    while(iterator.hasNext()) {
                        Shape cur=iterator.next();
                        cur.step();
                    }
                    try {
                        repaint();
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point curLocation = new Point(e.getX(),e.getY());
                Point dif = curLocation.subtract(previousMouseLocation);
                previousMouseLocation = curLocation;
                if(selectedShape != null) {
                    selectedShape.setLocation(selectedShape.getLocation().add(dif));
                    if ( selectedShape instanceof Line){
                        System.out.println("instance of line");
                        ((Line) selectedShape).setStartPoint(((Line) selectedShape).getStartPoint().add(dif));
                        ((Line) selectedShape).setEndPoint(((Line) selectedShape).getEndPoint().add(dif));
                    }
                }
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //Point curLocation=new Point(e.getX(),e.getY());
                //Point dif=curLocation.subtract(previousMouseLocation);
            }
        });

        addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed( MouseEvent e) {
                previousMouseLocation = new Point(e.getX(),e.getY());
                Iterator<Shape> iterator = shapes.iterator();
                while(iterator.hasNext()) {
                    Shape cur = iterator.next();
                    if(cur.IsIn( previousMouseLocation )) {
                        setSelectedShape(cur);
                        previousSelectedShape = cur;
                        System.out.println("selected");
                        System.out.println(selectedShape);
//                        shapePropertiesPanel.addPanel( cur.getPropertiesPanel() );
                        shapePropertiesPanel.shape = cur;
                        shapePropertiesPanel.xTextField.setText(String.valueOf(cur.getLocation().getX()));
                        shapePropertiesPanel.yTextField.setText(String.valueOf(cur.getLocation().getY()));
                        if ( cur instanceof Rectangle){
                            shapePropertiesPanel.remove(shapePropertiesPanel.radiusLabel);
                            shapePropertiesPanel.remove(shapePropertiesPanel.radiusTextArea);
                            shapePropertiesPanel.remove(shapePropertiesPanel.lineLabel);
                            shapePropertiesPanel.remove(shapePropertiesPanel.LineTextArea);
                            shapePropertiesPanel.add(shapePropertiesPanel.heightLabel);
                            shapePropertiesPanel.add(shapePropertiesPanel.HeightTextArea);
                            shapePropertiesPanel.add(shapePropertiesPanel.widthLabel);
                            shapePropertiesPanel.add(shapePropertiesPanel.WidthTextArea);
                            shapePropertiesPanel.add(shapePropertiesPanel.empty);
                            shapePropertiesPanel.add(shapePropertiesPanel.applyButton);
                            shapePropertiesPanel.HeightTextArea.setText(String.valueOf(((Rectangle) cur).getHeight()));
                            shapePropertiesPanel.WidthTextArea.setText(String.valueOf(((Rectangle) cur).getWidth()));
                            shapePropertiesPanel.revalidate();
                            shapePropertiesPanel.repaint();
                        }
                        if ( cur instanceof Circle){
                            shapePropertiesPanel.remove(shapePropertiesPanel.heightLabel);
                            shapePropertiesPanel.remove(shapePropertiesPanel.widthLabel);
                            shapePropertiesPanel.remove(shapePropertiesPanel.WidthTextArea);
                            shapePropertiesPanel.remove(shapePropertiesPanel.HeightTextArea);
                            shapePropertiesPanel.remove(shapePropertiesPanel.lineLabel);
                            shapePropertiesPanel.remove(shapePropertiesPanel.LineTextArea);
                            shapePropertiesPanel.add(shapePropertiesPanel.radiusLabel);
                            shapePropertiesPanel.add(shapePropertiesPanel.radiusTextArea);
                            shapePropertiesPanel.add(shapePropertiesPanel.empty);
                            shapePropertiesPanel.add(shapePropertiesPanel.applyButton);
                            shapePropertiesPanel.radiusTextArea.setText(String.valueOf(((Circle) cur).radius));
                            shapePropertiesPanel.revalidate();
                            shapePropertiesPanel.repaint();
                        }
                        if ( cur instanceof Line ){
                            shapePropertiesPanel.remove(shapePropertiesPanel.radiusLabel);
                            shapePropertiesPanel.remove(shapePropertiesPanel.radiusTextArea);
                            shapePropertiesPanel.remove(shapePropertiesPanel.heightLabel);
                            shapePropertiesPanel.remove(shapePropertiesPanel.widthLabel);
                            shapePropertiesPanel.remove(shapePropertiesPanel.WidthTextArea);
                            shapePropertiesPanel.remove(shapePropertiesPanel.HeightTextArea);
                            shapePropertiesPanel.add(shapePropertiesPanel.lineLabel);
                            shapePropertiesPanel.add(shapePropertiesPanel.LineTextArea);
                            shapePropertiesPanel.add(shapePropertiesPanel.empty);
                            shapePropertiesPanel.add(shapePropertiesPanel.applyButton);
                            Point dif = ((Line) cur).endPoint.subtract(((Line) cur).startPoint);
                            shapePropertiesPanel.LineTextArea.setText( dif.toString());
                            shapePropertiesPanel.revalidate();
                            shapePropertiesPanel.repaint();

                        }

                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                shapePropertiesPanel.xTextField.setText(String.valueOf(selectedShape.getLocation().getX()));
                shapePropertiesPanel.yTextField.setText(String.valueOf(selectedShape.getLocation().getY()));
                previousMouseLocation=null;
                selectedShape=null;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        animationThread.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        System.out.println("paint component accessed");
        Iterator<Shape> cur = shapes.iterator();
        while( cur.hasNext() ){
            Shape shape = cur.next();
            shape.render((Graphics2D)g);
        }

    }




}
