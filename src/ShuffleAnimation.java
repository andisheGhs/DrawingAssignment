public class ShuffleAnimation extends Animation {
    PaintPanel paintPanel;
    Image shape;
    int counter = 1 , timeCounter = 0;
    int time = 10;

    ShuffleAnimation(int stepDelay) {
        super(stepDelay);
    }

    @Override
    public void step() {
        System.out.println("2");
        int timeLimit = time / shape.images.size();
        if ( counter < shape.images.size() ){
            if ( timeCounter < timeLimit ) {
                timeCounter++;
                if (timeCounter == timeLimit) {
                    System.out.println("1");
                    shape.image = shape.images.get(counter);
                    paintPanel.repaint();
                    counter++;
                    timeCounter = 0;
                }
            }
        }
        if ( counter >= shape.images.size() )
            counter = 0;
            System.out.println("3");
        }
    }

