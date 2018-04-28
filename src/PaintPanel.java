import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class PaintPanel extends JPanel {
    ArrayList<Shape> shapes = new ArrayList<>();
    Point previousMouseLocation = null;
    Shape selectedShape = null;
    Thread animationThread = null;
    boolean animating;
    ShapePropertiesPanel shapePropertiesPanel = new ShapePropertiesPanel(selectedShape , this);

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
                        selectedShape = cur;
                        System.out.println("selected");
//                        shapePropertiesPanel.addPanel( cur.getPropertiesPanel() );
                        shapePropertiesPanel.shape = cur;
                        shapePropertiesPanel.xTextField.setText(String.valueOf(cur.getLocation().getX()));
                        shapePropertiesPanel.yTextField.setText(String.valueOf(cur.getLocation().getY()));

                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
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
