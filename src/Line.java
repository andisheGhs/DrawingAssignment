import java.awt.*;

public class Line extends Shape {
    Point startPoint = null;
    Point endPoint = null ;
    private double shib;

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Line(Point location , Point startPoint , Point endPoint) {
        super(location);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        if (  startPoint.getX() == endPoint.getX() ){
            shib = Double.parseDouble(null);
        } else {
            shib = (startPoint.getY() - endPoint.getY()) / ( startPoint.getX() - endPoint.getX());
        }
        System.out.println("new Line");
    }

    public Line(Point location, Color solidColor, Color borderColor , Point startPoint , Point endPoint) {
        super(location, solidColor, borderColor);
        this.endPoint = endPoint;
        this.startPoint = startPoint;
    }

    @Override
    public boolean IsIn(Point point) {
        if ( (int) (point.subtract(startPoint).getRad() + point.subtract(endPoint).getRad() )
                == (int) startPoint.subtract(endPoint).getRad() ){
            return true;
        }


//        if ( startPoint.getX() > endPoint.getX() ){
//            if ( startPoint.getX() > point.getX() && endPoint.getX() < point.getX() ){
//                if ( startPoint.getY() > endPoint.getY() ) {
//                    if (startPoint.getY() > point.getY() && endPoint.getY() < point.getY()) {
//                        if ( shib == ( point.getY() - startPoint.getY() ) / ( point.getX() - startPoint.getX() ) ){
//                            return true;
//                        }
//                    }
//                } else if (startPoint.getY() < point.getY() && endPoint.getY() > point.getY()) {
//                    if ( shib == ( point.getY() - startPoint.getY() ) / ( point.getX() - startPoint.getX() ) ){
//                        return true;
//                    }
//                }
//            }
//        } else if ( startPoint.getX() < point.getX() && endPoint.getX() > point.getX() ) {
//            if ( startPoint.getY() > endPoint.getY() ) {
//                if (startPoint.getY() > point.getY() && endPoint.getY() < point.getY()) {
//                    if ( shib == ( point.getY() - startPoint.getY() ) / ( point.getX() - startPoint.getX() ) ){
//                        return true;
//                    }
//                }
//            } else if (startPoint.getY() < point.getY() && endPoint.getY() > point.getY()) {
//                if ( shib == ( point.getY() - startPoint.getY() ) / ( point.getX() - startPoint.getX() ) ){
//                    return true;
//                }
//            }
//        }
            return false;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public void render(Graphics2D g2) {
        super.render(g2);
        Stroke stroke = g2.getStroke();
        g2.setColor(solidColor);
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(borderColor);
        g2.drawLine((int) startPoint.getX() , (int) startPoint.getY() , (int) endPoint.getX() , (int) endPoint.getY());
        g2.setStroke(stroke);
    }
}
