package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Spieler extends GraphicalObject {
    private BufferedImage player1;
    private BufferedImage player2;
    private int speed;
    private int stamina;
    private int radius;
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    public Spieler(double x, double y){
        setNewImage("assets/images/bay");
        setNewImage("assets/images/th");
        speed = (int)(Math.random()*10+20);
        stamina = 100;
        this.x = x;
        this.y = y;
        radius = 10;

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.drawImage(player1,200,200);
        drawTool.drawImage(player2,300,300);
    }

    @Override
    public void update(double dt) {
        if(right){
            x+=speed*dt;
        }
        if(left){
            x-=speed*dt;
        }
        if(up){
            y-=speed*dt;
        }
        if(down){
            y+=speed*dt;
        }



    }

    public boolean getLeft(){
        return left;
    }
    public boolean getRight(){
        return right;
    }

    public boolean getUp(){
        return up;
    }
    public boolean getDown(){
        return down;
    }
    public int getSpeed() {
        return speed;
    }

    public int getStamina() {
        return stamina;
    }

    public int getRadius(){
        return radius;
    }

    public void recharge(){
        if (stamina>100 ||stamina != 100){
            stamina++;
        }
    }
}
