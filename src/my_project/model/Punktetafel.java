package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Punktetafel extends  GraphicalObject {
    private  String text;
    public Punktetafel( String text){

        this.text = text;

    }
    @Override
    public void draw(DrawTool drawTool) {

        drawTool.drawText(400,200,text);
    }

    @Override
    public void update(double dt) {

    }
}
