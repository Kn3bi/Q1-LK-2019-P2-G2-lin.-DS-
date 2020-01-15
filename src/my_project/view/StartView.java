package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class StartView extends GraphicalObject {

    public StartView(){

    }

    //TODO Starttext als Bild

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawText(50,100,"StartView");
    }

    @Override
    public void update(double dt) {

    }
}
