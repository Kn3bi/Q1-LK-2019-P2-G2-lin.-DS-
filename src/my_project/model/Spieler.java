package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Spieler extends GraphicalObject {
    private BufferedImage player1;
    private BufferedImage player2;
    private int speed;
    private int stamina;
    private int radius;
    private boolean pic;
    private boolean elfertuechtig;
    private boolean ingame;

    public Spieler (double x, double y, boolean teamA){
        try {
            player1 = ImageIO.read(new File("assets/images/goku.png"));
        } catch (IOException e){
            System.out.println("no");
        }
        speed = (int)(Math.random()*10+100);
        stamina = 100;
        this.x = x;
        this.y = y;
        radius = 30;
        pic = teamA;
        elfertuechtig= false;
        ingame = false;

    }

    @Override
    public void draw(DrawTool drawTool) {

        drawTool.drawFilledCircle(x,y,radius);

            drawTool.drawImage(player1,x,y);


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
