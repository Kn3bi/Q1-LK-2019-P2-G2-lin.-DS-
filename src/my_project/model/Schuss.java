package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Schuss extends GraphicalObject {
    private int radius;
    private int speed;


public Schuss(double x, double y,double width,double height) {
    speed = (int) (Math.random() * 10 + 100);
    radius = 10;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
}

    @Override
    public void draw (DrawTool drawTool){
        speed = (int) (Math.random() * 10 + 100);
        drawTool.drawFilledRectangle(x,y,width,height);
    }

    @Override
    public void update ( double dt){

    }
    public double  getWidth(){return width;}
    public double getHeight(){return  height;}
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
