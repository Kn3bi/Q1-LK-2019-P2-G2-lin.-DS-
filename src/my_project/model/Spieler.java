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
