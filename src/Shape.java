import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Shape implements Drawable , Animatable {
    protected Point location;
    protected int thickness = 5;
    protected Color solidColor = Color.WHITE;
    protected Color borderColor = Color.BLACK;
    protected ArrayList< Animation > animations = new ArrayList< Animation >();
    protected JPanel propertiesPanel;

    public JPanel getPropertiesPanel() {
        return propertiesPanel;
    }

    public void setPropertiesPanel(JPanel propertiesPanel) {
        this.propertiesPanel = propertiesPanel;
    }

    public Shape(Point location) {
        this.location = location;
    }

    public Shape(Point location, Color solidColor, Color borderColor) {
        this.location = location;
        this.solidColor = solidColor;
        this.borderColor = borderColor;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public Color getSolidColor() {
        return solidColor;
    }

    public void setSolidColor(Color solidColor) {
        this.solidColor = solidColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public ArrayList<Animation> getAnimations() {
        return animations;
    }

    public void setAnimations(ArrayList<Animation> animations) {
        this.animations = animations;
    }

    public void addAnimation( Animation animation ){
        animations.add(animation);
    }

    public abstract boolean IsIn(Point point);
    public abstract double getArea();

    @Override
    public void step() {
        Iterator< Animation > cur = animations.iterator();
        while ( cur.hasNext() ){
            cur.next().animate();
        }
    }

    @Override
    public void render(Graphics2D g2) {

    }
}
