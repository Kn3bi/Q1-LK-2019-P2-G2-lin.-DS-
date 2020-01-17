package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.util.Stack;

public class Elfmeter extends GraphicalObject {

    private Stack<Spieler> elfmeter;
    private Ball ball;

    public Elfmeter(Ball ball){
        elfmeter = new Stack<>();
        this.ball= ball;
    }

    public void draw(DrawTool drawTool){

    }
    public void update(double dt){

    }
    public void fuelleElfmeterTeam(Spieler spieler){
        if(spieler.getElferSchuetze()==true){
            elfmeter.push(spieler);
        }
    }
}
