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

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(bild,x,y);
    }

    @Override
    public void update(double dt) {

    }
}
