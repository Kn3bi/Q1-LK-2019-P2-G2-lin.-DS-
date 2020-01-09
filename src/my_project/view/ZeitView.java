package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ZeitView extends GraphicalObject {

    private int zeit;

    public ZeitView(){
        zeit = 0;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawText(900,100,""+zeit);
    }

    @Override
    public void update(double dt) {
        zeit = (int)(zeit+dt);
    }
}
