package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class SpielView extends GraphicalObject {
    private BufferedImage feld;

    public SpielView(){
        setNewImage("assets/images/field.png");
        feld = getMyImage();

    }

    /**
     * zeichnet das Spielfeld
     * @param drawTool
     */
    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(feld,0,0);

    }

    /**
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    @Override
    public void update(double dt) {

    }
}
