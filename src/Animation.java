import java.util.Date;

public abstract class Animation implements Animatable {
    boolean animating=true;
    Date nextAnimation=new Date();
    int stepDelay;
    AnimationMenuPanel animationMenuPanel;

    public void setAnimationMenuPanel(AnimationMenuPanel animationMenuPanel) {
        this.animationMenuPanel = animationMenuPanel;
    }

    public boolean getAnimating() {
        return animating;
    }

    public void setAnimating(boolean animating) {
        this.animating = animating;
    }

    public int getStepDelay() {
        return stepDelay;
    }

    public void setStepDelay(int stepDelay) {
        this.stepDelay = stepDelay;
    }

    Animation(int stepDelay) {
        this.stepDelay=stepDelay;
        nextAnimation=new Date();
        animating=true;
    }

    public void animate() {
        if(animating) {
            if (nextAnimation.before(new Date())) {
                step();
                nextAnimation.setTime(new Date().getTime() + stepDelay);
            }
        }
    }
}