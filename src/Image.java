import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Image extends Shape {
    PaintPanel paintPanel;
    ArrayList< BufferedImage > images = new ArrayList<>();
    BufferedImage image;

    public Image(Point location , PaintPanel paintPanel) {
        super(location);
        this.paintPanel = paintPanel;
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(paintPanel);
        try {
            image = ImageIO.read(jfc.getSelectedFile());
            images.add(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean IsIn(Point point) {
        Point dif = point.subtract(location);
        if (dif.getX() > 0 && dif.getY() > 0 && dif.getX() < 100 && dif.getY() < 100    )
            return true;
        return false;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public void render(Graphics2D g2) {
        super.render(g2);
        g2.drawImage(image , (int) getLocation().getX(), (int) getLocation().getY(), 100 , 100 ,  paintPanel);
    }

    @Override
    public void step() {
        super.step();
    }

    public void addImage(){
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(paintPanel);
        BufferedImage image1 = null;
        try {
            image1 = ImageIO.read(jFileChooser.getSelectedFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(image1);

        images.add(image1);
    }

}
