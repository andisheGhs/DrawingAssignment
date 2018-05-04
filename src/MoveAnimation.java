public class MoveAnimation extends Animation {
    Shape shape;
    double x =0;
    double y =0;
    double startX , endX;
    double endY , startY;
    double difX , difY;
    boolean isGoingRight;
    boolean isGoingUp;
    boolean isRepeating = true;
    PaintPanel paintPanel;
    AnimationMenuPanel animationMenuPanel;
    int time = 100;
    int i = 0;

    MoveAnimation(int stepDelay) {
        super(stepDelay);
    }

    @Override
    public void step() {
        isRepeating = animationMenuPanel.isInRepeatMood;
        if ( shape instanceof  Circle || shape instanceof Rectangle){
            if ( i ==0 ){
                startX = shape.getLocation().getX();
                startY = shape.getLocation().getY();
                endX = shape.getLocation().getX() + x;
                endY = shape.getLocation().getY() + y;
                difX = Math.abs(endX - startY) / (time / stepDelay);
                difY = Math.abs(endY - startY) / (time / stepDelay);
                if ( y > 0 ){
                    isGoingUp = false;
                } else {
                    isGoingUp = true;
                }
                if ( x > 0 ){
                    isGoingRight = true;
                } else {
                    isGoingRight = false;
                }
                i++;
            }

            System.out.println("isGoingRight : " + isGoingRight);
            System.out.println("isGoingUp: " + isGoingUp );
            System.out.println("isRepeating : " + isRepeating);

            if ( (shape.getLocation().getY() == endY || shape.getLocation().getY() == startY) && i != 0 && isRepeating ){
                System.out.println("miad inja");
                isGoingUp = !isGoingUp;
                isGoingRight = !isGoingRight;
            }

            if ( shape.getLocation().getX() < endX  && isGoingRight && !isGoingUp){
                System.out.println("here is the endX : " + endX);
                System.out.println("here is the locationX : " + shape.getLocation().getX());
                shape.setLocation(new Point(shape.getLocation().getX() + difX, shape.getLocation().getY() + difY));
            }
            if ( shape.getLocation().getX() > startX  && isGoingUp && !isGoingRight ) {
                System.out.println("here is the endX : " + endX);
                System.out.println("here is the locationX : " + shape.getLocation().getX());
                shape.setLocation(new Point(shape.getLocation().getX() - difX, shape.getLocation().getY() - difY));
            }
            if ( shape.getLocation().getX() > endX  && !isGoingRight &&
                    shape.getLocation().getY() < endY && !isGoingUp ){
                shape.setLocation(new Point(shape.getLocation().getX() - difX, shape.getLocation().getY() + difY));
            }
            if ( shape.getLocation().getX() < endX && isGoingRight &&
                    shape.getLocation().getY() > startY  && isGoingUp ){
                shape.setLocation(new Point(shape.getLocation().getX() + difX, shape.getLocation().getY() - difY));
            }
            paintPanel.repaint();
        }
    }
}
