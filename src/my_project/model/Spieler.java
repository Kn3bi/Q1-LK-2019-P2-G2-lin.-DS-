package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Spieler extends GraphicalObject {

    private int speed;
    private int stamina;
    private int radius;
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    public Spieler(double x, double y){
        speed = (int)(Math.random()*10+20);
        stamina = 100;
        this.x = x;
        this.y = y;
        radius = 10;

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawFilledCircle(x,y,radius);
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
