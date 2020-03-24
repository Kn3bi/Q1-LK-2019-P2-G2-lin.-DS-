package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class EndeView extends GraphicalObject {
    private BufferedImage win1,win2,win3;
    private String siegerSituation;
    private boolean w1t,w2t,w3t;

    /**
     * zeichnet den Endtext
     * @param drawTool
     */
    @Override
    public void draw(DrawTool drawTool) {
        if (w1t) {
            win1 = createImage("assets/images/tip1.jpg");
        }
        if(w2t){
        win2 = createImage("assets/images/tip2.jpg");
    }
        if(w3t) {
            win3 = createImage("assets/images/tip3.jpg");
        }

    }

    @Override
    public void update(double dt) {

    }

    public void setSiegerSituation(String siegerSituation) {
        this.siegerSituation = siegerSituation;
    }

    public boolean isW3t() {
        return w3t;
    }

    public void setW3t(boolean w3t) {
        this.w3t = w3t;
    }

    public boolean isW2t() {
        return w2t;
    }

    public void setW2t(boolean w2t) {
        this.w2t = w2t;
    }

    public boolean isW1t() {
        return w1t;
    }

    public void setW1t(boolean w1t) {
        this.w1t = w1t;
    }
}
