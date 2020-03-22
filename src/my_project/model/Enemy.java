package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy extends GraphicalObject {
    private BufferedImage player2;

    private int speed;

    private int radius;


    public  Enemy (double x, double y, boolean teamA){
        try {
            player2 = ImageIO.read(new File("assets/images/goku.png"));
        } catch (IOException e){
            System.out.println("no");
        }
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
