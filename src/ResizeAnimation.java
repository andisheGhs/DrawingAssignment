public class ResizeAnimation extends Animation {
    Shape shape;
    PaintPanel paintPanel;
    boolean isRepeating = false;
    boolean isIncreasing = true;
    double startRadius = 0 , endRadius = 0;
    double startWidth = 0 , endWidth = 0;
    double startHeight = 0 , endHeight = 0;
    public int number = 2;
    int time = 100;
    int i = 0 ;
    ResizeAnimation(int stepDelay) {
        super(stepDelay);
    }

    @Override
    public void step() {
        isRepeating = animationMenuPanel.isInRepeatMood;
        if ( shape instanceof  Circle){
            if ( i == 0 ) {
                startRadius = ((Circle) shape).getRadius();
                endRadius = ((Circle) shape).getRadius() * number;
                i++;
            }
            double dif = Math.abs(startRadius - endRadius);
            double inEachTime = dif / (time / stepDelay);
            if ( ((Circle) shape).getRadius() == endRadius && isRepeating ){
                isIncreasing = false;
            }
            if ( ((Circle) shape).getRadius() == startRadius && isRepeating ){
                isIncreasing = true;
            }
            if ( ((Circle) shape).getRadius() < endRadius  && isIncreasing) {
                ((Circle) shape).setRadius(((Circle) shape).getRadius() + inEachTime);
            } else if ( ((Circle) shape).getRadius() > startRadius && !isIncreasing ){
                ((Circle) shape).setRadius(((Circle) shape).getRadius() - inEachTime);
            }
            paintPanel.repaint();
        }
        if ( shape instanceof Rectangle ){
            if ( i == 0 ){
                startHeight = ((Rectangle)shape).getHeight();
                startWidth = ((Rectangle) shape).getWidth();
                endHeight = ((Rectangle) shape).getWidth() * number;
                endWidth = ((Rectangle) shape).getWidth() * number;
                i++;
            }
            double difWidth = Math.abs(endWidth - startWidth);
            double difHeight = Math.abs(endHeight - startHeight);
            double inEachTimeWidth = difWidth / (time / stepDelay);
            double inEachTimeHeight = difHeight / (time / stepDelay);
            if ( ((Rectangle) shape).getWidth() == startWidth ){
                isIncreasing = true;
            }
            if ( ((Rectangle) shape).getWidth() == endWidth){
                isIncreasing = false;
            }
            if (((Rectangle) shape).getWidth() < endWidth && isIncreasing){
                ((Rectangle)shape).setWidth(((Rectangle)shape).getWidth() + inEachTimeWidth);
                ((Rectangle)shape).setHeight(((Rectangle)shape).getHeight() + inEachTimeHeight);

            } else if (((Rectangle)shape).getWidth() > startWidth && !isIncreasing){
                ((Rectangle)shape).setWidth(((Rectangle)shape).getWidth() - inEachTimeWidth);
                ((Rectangle)shape).setHeight(((Rectangle)shape).getHeight() - inEachTimeHeight);
            }
            paintPanel.repaint();

        }
    }

}
