package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.DrawTool;

public class Mannschaft2 extends GraphicalObject {

    private Queue<Enemy> mannschaft2;
    private Ball ball;


    public Mannschaft2(Ball ball){
        mannschaft2 = new Queue<>();
        this.ball = ball;
    }
    public Queue getEnemy(){return mannschaft2;}

    @Override
    public void draw(DrawTool drawTool) {
        while(!mannschaft2.isEmpty()){
            mannschaft2.front().draw(drawTool);
            mannschaft2.dequeue();
        }

    }
    public Enemy getAktSpieler(){
        return mannschaft2.front();
    }
    @Override
    public void update(double dt) {

    }

    /**
     * Diese Methode dient der Auffüllung der Liste (extern)
     */
    public void fuelleEnemies(Enemy enemy)
    {

            mannschaft2.enqueue(enemy);

    }









    /**
     * Die Methode dient dazu um zum Spieler zu wechseln der näher am Ball ist.
     * Die Methode setzt den aktuellen Spieler der Liste(current)
     * auf den Spieler, der am nächsten zum Ball ist
     */
    public void changeSpieler(){
        boolean playerA = false;
        boolean playerB = false;
        double pA = 0;
        double pB = 0;
        double pC = 0;
        double midXBall = ball.getX();
        double midYBall = ball.getY();
        //-----------------------------------------------------------------------------
        //geht die Mannschaft einmal durch, vom ersten bis zum letzten Spieler
        // und berechnet für jeden den Abs     }
    }

    /**
     * Die Methode dient zur Auswechslung von Spielern, falls deren Ausdauer unter 0 fallen.
     */

}
