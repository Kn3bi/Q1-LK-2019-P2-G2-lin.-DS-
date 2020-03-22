package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class EndeView extends GraphicalObject {

    private String siegerSituation;

    /**
     * zeichnet den Endtext
     * @param drawTool
     */
    @Override
    public void draw(DrawTool drawTool) {
       drawTool.drawText(200,300,"TIPICO UNLIMITED");
        ;
    }

    @Override
    public void update(double dt) {

    }

    public void setSiegerSituation(String siegerSituation) {
        this.siegerSituation = siegerSituation;
    }
}
