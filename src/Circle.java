import java.awt.*;

public class Circle extends Shape {
    protected double radius = 100;



    public Circle(Point location  , double radius) {
        super(location);
        this.radius = radius;
//        System.out.println("new circle" );
//        setPropertiesPanel(new CirclePropertiesPanel(this , 100));

    }

    public Circle(Point location, double radius ,  Color solidColor, Color borderColor) {
        super(location, solidColor, borderColor);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean IsIn(Point point) {
        double distance = location.subtract(point).getRad();
        return distance < radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void step() {
        super.step();
    }

    @Override
    public void render(Graphics2D g2) {
        super.render(g2);
//        System.out.println("circle render");
        g2.setColor( solidColor );
        g2.fillOval((int)( location.x - radius ),(int)( location.y - radius),(int)radius * 2,(int)radius * 2);
        Stroke stroke = g2.getStroke();
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(borderColor);
        g2.drawOval((int)(location.x - radius),(int)( location.y-radius),(int)radius * 2  ,(int)radius * 2);
        g2.setStroke(stroke);
    }
}
