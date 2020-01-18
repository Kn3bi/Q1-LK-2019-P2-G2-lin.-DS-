package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class AnleitungsView extends GraphicalObject {
    private BufferedImage anleitung;

    public AnleitungsView(){
        x = 0;
        y = 0;
        anleitung = createImage("assets/images/anleitungsBild.png");
    }


    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(anleitung,x,y);
    }

    @Override
    public void update(double dt) {

    }
}
