package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.*;
import my_project.model.Ball;
import my_project.model.Enemy;



import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;


public class Enemy extends GraphicalObject {
    private BufferedImage player2;

    private int speed;

    private int radius;


    public  Enemy (double x, double y){

            //player2 = createImage("assets/images/goku.png");
        setNewImage("assets/images/goku.png");
            player2=getMyImage();
        speed = (int)(Math.random()*10+100);
        this.x = x;
        this.y = y;
        radius = 30;


    }

    @Override
    public void draw(DrawTool drawTool) {

        drawTool.drawFilledCircle(x,y,radius);

        drawTool.drawImage(player2,x,y);




    }

    @Override
    public void update(double dt) {

    }

    public double getX(){
        return x;
    }

    @Override
    public void setX(double x) {
        super.setX(x);
    }

    @Override
    public void setY(double y) {
        super.setY(y);
    }

    public void setSpeed(int speed){
        this.speed=speed;
    }

    public int getSpeed() {
        return speed;
    }


    public int getRadius(){
        return radius;
    }


    /**
     * Die Methode dient zur Auffüllung der Ausdauer. Wenn diese unter 100 ist soll sie um eins erhöht werden.
     */

}
