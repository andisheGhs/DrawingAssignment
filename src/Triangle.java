import java.awt.*;

public class Triangle extends Shape {
    Point[] vertices;

    public Triangle(Point a,Point b, Point c,Color solidColor, Color borderColor) {
        super(new Point((a.getX()+b.getX()+c.getX())/3,(a.getY()+b.getY()+c.getY())/3),solidColor,borderColor);
        vertices = new Point[] { a.subtract(location) , b.subtract(location) , c.subtract(location)};
    }

    public Triangle(Point a,Point b, Point c) {
        this( a , b , c , Color.BLUE , Color.ORANGE );
    }

    @Override
    public boolean IsIn(Point point) {

        return false;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public void render(Graphics2D g2) {
        super.render(g2);
        g2.setColor(solidColor);
        Point positions[]=new Point[]{vertices[0].add(location),vertices[1].add(location),vertices[2].add(location)};
        int Xs[]=new int[]{(int)positions[0].getX(),(int)positions[1].getX(),(int)positions[2].getX()};
        int Ys[]=new int[]{(int)positions[0].getY(),(int)positions[1].getY(),(int)positions[2].getY()};
        g2.fillPolygon(Xs,Ys,Xs.length);

        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(borderColor);
        g2.drawPolygon(Xs,Ys,Xs.length);
    }
}
