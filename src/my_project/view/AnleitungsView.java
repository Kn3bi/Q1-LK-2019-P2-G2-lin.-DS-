package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class AnleitungsView extends GraphicalObject {

    public AnleitungsView(){
        x = 200;
        y = 100;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawText(x,y,"Wilkommen! Dies ist ein Fußballspiel.\n" +
                "Dein Ziel ist es so viele Tore wie möglich zu schießen.\n" +
                "\n" +
                "Spieler 1 steuert mit den Tasten W,A,S,D seine Figur \n" +
                "Spieler 2 seine Figur mit den Pfeiltasten");
    }

    @Override
    public void update(double dt) {

    }
}
