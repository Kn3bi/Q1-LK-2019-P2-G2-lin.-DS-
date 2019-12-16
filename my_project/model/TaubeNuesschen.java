package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;


public class TaubeNuesschen extends GraphicalObject {

    public TaubeNuesschen(int x , int y){
        this.x= x;
        this.y= y;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,100);
        drawTool.drawFilledCircle(x+10,y+20,100);

    }
    public void update(double dt){
        x = x +200*dt;

    }


}
