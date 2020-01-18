package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class Tor extends GraphicalObject {

    private Ball ball;


    public Tor(Ball ball){
        this.ball = ball;
    }


    public void draw(DrawTool drawTool){
        drawTool.drawLine(100,300,100,400);
        drawTool.drawLine(900,300,900,400);
}


    public void update(double dt){


}
}
