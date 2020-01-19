package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class StartView extends GraphicalObject {

    private BufferedImage bild;

    public StartView(){
        bild = createImage("assets/images/StartBild.png");
        x = 0;
        y= 0;
    }

    /**
     * zeichnet den Startbildschirm
     * @param drawTool
     */
    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(bild,x,y);
    }

    /**
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    @Override
    public void update(double dt) {

    }
}
