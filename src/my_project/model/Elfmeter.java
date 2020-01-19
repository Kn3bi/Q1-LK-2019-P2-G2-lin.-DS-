package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.util.Stack;

public class Elfmeter extends GraphicalObject {



    private Stack<Spieler> elfmeter;
    private Ball ball;
    private double h;
    private double z;

    public Elfmeter(Ball ball){
        elfmeter = new Stack<>();
        this.ball= ball;
    }

    public void draw(DrawTool drawTool){

    }

    public void update(double dt){

    }

    /**
     * In dieser Methode werden die Spieler in dasStack gepackt, falls deren Attribut true ist.
     * @param spieler
     */
    public void fuelleElfmeterTeam(Spieler spieler){
        if(spieler.getElferSchuetze()==true){
            elfmeter.push(spieler);
        }
    }

    public void elfmeterKollision(Ball ball,Tor tor) {
        if (ball.getX() < tor.getX()) {
            z = tor.getX();
        } else if (ball.getX() > tor.getX() + tor.getWidth()) {
            z = tor.getX() + tor.getWidth();
        }
        if (ball.getY() < tor.getY()) {
            h = ball.getY();
        } else if (ball.getY() > tor.getY() + tor.getHeight()) {
            z = tor.getY() + tor.getHeight();

        }
    }
}
