package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Ball extends GraphicalObject {

    private int radius;
    private double vx,vy;

    public Ball(double x,double y){
        this.x = x;
        this.y = y;
        radius = 60;
        vx=0;
        vy=0;
    }

    /**
     * Dient zum zeichnen des Balles
     * @param drawTool Zum zeichnen da
     */
    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawFilledCircle(x,y,radius);
    }

    /**
     * dient zur bewegen des Balles
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    @Override
    public void update(double dt) {
        x=x+vx*dt;
        y=y+vy*dt;
        if(x>1500){
            x=1500;
            vx=-vx;
        }
        if(x<0){
            x=0;
            vx=-vx;
        }
        if(y>1029){
            y=1029;
            vy=-vy;
        }
        if(y<0){
            y=0;
            vy=-vy;
        }

    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;

    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }
}
