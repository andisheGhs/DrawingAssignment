import java.awt.*;

public class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(Point upperLeft , double width , double height) {
        super(upperLeft);
        this.width = width;
        this.height = height;

    }

    public Rectangle(Point upperLeft, double width , double height ,  Color solidColor, Color borderColor) {
        super(upperLeft , solidColor, borderColor);
        this.height = height;
        this.width = width;

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void render(Graphics2D g2) {
        super.render(g2);
        Stroke stroke = g2.getStroke();
        g2.setColor(solidColor);
        g2.fillRect((int) location.x, (int) location.y, (int) width, (int) height);

        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(borderColor);
        g2.drawRect((int) location.x , (int) location.y, (int) width, (int) height);

        g2.setStroke(stroke);
    }

    @Override
    public boolean IsIn(Point point) {
        Point dif = point.subtract(location);
        if (dif.getX() > 0 && dif.getY() > 0 && dif.getX() < width && dif.getY() < height)
            return true;
        return false;
    }

    @Override
    public double getArea() {
        return width * height ;
    }
}
