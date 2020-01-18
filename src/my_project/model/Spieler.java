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
    private boolean pic;
    private boolean elfertuechtig;
    private boolean ingame;

    public Spieler(double x, double y, boolean teamA){
        player1 = createImage("assets/images/bay.jpg");
        player2 = createImage("assets/images/th.jpg");
        speed = (int)(Math.random()*10+100);
        stamina = 100;
        this.x = x;
        this.y = y;
        radius = 160;
        pic = teamA;
        elfertuechtig= false;
        ingame = false;

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawFilledCircle(x,y,radius);
        if (!pic){
            drawTool.drawImage(player1,x,y);
        }else{
            drawTool.drawImage(player2,x,y);
        }
        drawTool.drawCircle(x,y,radius);

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

    public int getStamina() {
        return stamina;
    }

    public int getRadius(){
        return radius;
    }

    public boolean getElferSchuetze(){return elfertuechtig; }

    public boolean getIngame() { return ingame; }

    public void setIngame(boolean ingame) {
        this.ingame = ingame;
    }

    public void setElfertuechtig(boolean elfertuechtig) {
        this.elfertuechtig = elfertuechtig;
    }

    /**
     * Die Methode dient zur Auffüllung der Ausdauer. Wenn diese unter 100 ist soll sie um eins erhöht werden.
     */
    public void recharge(){
        if (stamina<100){
            stamina++;
        }
    }
}
