package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ZeitView extends GraphicalObject {

    private double zeit;

    public ZeitView(){
        zeit = 0;
    }

    /***
     * zeichnet deie Zeitanzeige
     * @param drawTool
     */
    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawText(900,100,""+((int)zeit));
    }

    /**
     * Zeit soll erhöht werden
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    @Override
    public void update(double dt) {
        zeit = zeit+dt;
    }

    public double getZeit() {
        return zeit;
    }
}
