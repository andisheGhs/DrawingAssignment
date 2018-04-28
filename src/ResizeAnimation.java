public class ResizeAnimation extends Animation {
    Shape shape;
    PaintPanel paintPanel;
    int time;
    ResizeAnimation(int stepDelay) {
        super(stepDelay);
    }

    @Override
    public void step() {
        if ( shape instanceof  Circle){
            double startRadius = ((Circle) shape).getRadius();
            double endRadius = ((Circle) shape).getRadius() * 2 ;
            double dif = Math.abs(startRadius - endRadius);
            double inEachTime = dif / (time / stepDelay);
            ((Circle) shape).setRadius(((Circle) shape).getRadius() + inEachTime );
            paintPanel.repaint();
        }
    }
}
