package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class SpielView extends GraphicalObject {
    private BufferedImage feld;

    public SpielView(){
        setNewImage("assets/images/field");
        feld = getMyImage();

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(feld,0,0);

    }

    @Override
    public void update(double dt) {

    }
}
