package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Ball extends GraphicalObject {

    private int radius;

    public Ball(double x,double y){
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
