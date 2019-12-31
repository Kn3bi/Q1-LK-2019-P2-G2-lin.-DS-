package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Ball extends GraphicalObject {

    private Tor torA;
    private Tor torB;
    private int radius;

    public Ball(Tor torA, Tor torB,double x,double y){
        this.torA = torA;
        this.torB = torB;
        this.x = x;
        this.y = y;
        radius = 20;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawFilledCircle(x,y,radius);
    }

    @Override
    public void update(double dt) {

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
}
