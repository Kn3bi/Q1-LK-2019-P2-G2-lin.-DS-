package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.view.DrawTool;

public class Mannschaft extends GraphicalObject {

    private List<Spieler> mannschaft;
    private Ball ball;


    public Mannschaft(Ball ball){
        mannschaft = new List<>();
        this.ball = ball;
    }

    @Override
    public void draw(DrawTool drawTool) {
        mannschaft.toFirst();
        while(mannschaft.hasAccess()){
            mannschaft.getContent().draw(drawTool);
            mannschaft.next();
        }
    }

    @Override
    public void update(double dt) {

    }

    /**
     * Diese Methode dient der Auffüllung der Liste (extern)
     */
    public void fillTheTeam(Spieler spieler){
        mannschaft.append(spieler);
    }
public void delete(Spieler spieler){
        mannschaft.toFirst();
        mannschaft.remove();
}

    public List getMannschaft(){
        return mannschaft;
    }

    public Spieler getAktSpieler(){
        return mannschaft.getContent();
    }

    /**
     * Die Methode dient dazu um zum Spieler zu wechseln der näher am Ball ist.
     * Die Methode setzt den aktuellen Spieler der Liste(current)
     * auf den Spieler, der am nächsten zum Ball ist
     */
    public void changePlayer(){
        boolean playerA = false;
        boolean playerB = false;
        double pA = 0;
        double pB = 0;
        double pC = 0;
        double midXBall = ball.getX();
        double midYBall = ball.getY();
        //-----------------------------------------------------------------------------
        //geht die Mannschaft einmal durch, vom ersten bis zum letzten Spieler
        // und berechnet für jeden den Abstand zum BAll
        mannschaft.toFirst();
        while (mannschaft.hasAccess()) {
            double midXTeam = mannschaft.getContent().getX();
            double midYTeam = mannschaft.getContent().getY();
            if (!playerA) {
                pA = Math.sqrt(Math.pow(midXTeam - midXBall, 2) + Math.pow(midYTeam - midYBall, 2));
                playerA = true;
            } else if (!playerB) {
                pB = Math.sqrt(Math.pow(midXTeam - midXBall, 2) + Math.pow(midYTeam - midYBall, 2));
                playerB = true;
            } else {
                pC = Math.sqrt(Math.pow(midXTeam - midXBall, 2) + Math.pow(midYTeam - midYBall, 2));
            }
            mannschaft.next();
        }
        //setzt current auf den Spieler, der den kleinsten Abstand hat
        if(pA<=pB && pC>=pA){
            mannschaft.toFirst();
        }else if(pB<pA && pB<pC){
            mannschaft.toFirst();
            mannschaft.next();
        }else{
            mannschaft.toLast();
        }
    }

    /**
     * Die Methode dient zur Auswechslung von Spielern, falls deren Ausdauer unter 0 fallen.
     */
    public void auswecheln(Queue<Spieler> bank, Bank bench){
        mannschaft.toFirst();
        while (mannschaft.hasAccess()){
            if (mannschaft.getContent().getStamina()<=0){
                bank.enqueue(mannschaft.getContent());
                mannschaft.remove();
                bench.runterVonDerBank();
            }
            mannschaft.next();
        }
    }
}
