package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;
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

    public void fillTheTeam(Spieler spieler){
        mannschaft.append(spieler);
    }

    public List getMannschaft(){
        return mannschaft;
    }

    public Spieler getAktSpieler(){
        return mannschaft.getContent();
    }

    //chnagePlayer ist orientiert an getDistanceTo(GraphicalObject gO)
    public void changePlayer(){
        boolean playerA = false;
        boolean playerB = false;
        double pA = 0;
        double pB = 0;
        double pC = 0;
        double midX2 = ball.getX() + ball.getRadius();
        double midY2 = ball.getY() + ball.getRadius();
        //-----------------------------------------------------------------------------
        mannschaft.toFirst();
        while (mannschaft.hasAccess()) {
            double midX = mannschaft.getContent().getX() + mannschaft.getContent().getRadius();
            double midY = mannschaft.getContent().getY() + mannschaft.getContent().getRadius();
            if (!playerA) {
                pA = Math.sqrt(Math.pow(midX - midX2, 2) + Math.pow(midY - midY2, 2));
                playerA = true;
            } else if (!playerB) {
                pB = Math.sqrt(Math.pow(midX - midX2, 2) + Math.pow(midY - midY2, 2));
                playerB = true;
            } else {
                pC = Math.sqrt(Math.pow(midX - midX2, 2) + Math.pow(midY - midY2, 2));
            }
            mannschaft.next();
        }
        if(pA<=pB && pC>=pA){
            mannschaft.toFirst();
        }else if(pB<pA && pB<pC){
            mannschaft.toFirst();
            mannschaft.next();
        }else{
            mannschaft.toLast();
        }
        System.out.println(pA+" "+pB+" "+pC);
    }
}
