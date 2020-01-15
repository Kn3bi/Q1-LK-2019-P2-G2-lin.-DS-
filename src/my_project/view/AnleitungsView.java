package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class AnleitungsView extends GraphicalObject {
    private BufferedImage feld;

    public AnleitungsView(){
        x = 200;
        y = 50;

    }

    //TODO Bild als Anleitung

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawText(x,y,"AnleitungsView");
    }

    @Override
    public void update(double dt) {

    }
}
