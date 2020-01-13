package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import KAGO_framework.model.abitur.datenstrukturen.List;


/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute

    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Mannschaft mannschaftA;
    private Mannschaft mannschaftB;
    private Spieler     spielerA1;
    private Spieler     spielerA2;
    private Spieler     spielerA3;
    private Spieler     spielerB1;
    private Spieler     spielerB2;
    private Spieler     spielerB3;
    private Bank bankA;
    private Bank bankB;
    private Investoren[][] investoren;
    private Ball ball;
    private Tor torA, torB;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param ViewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController ViewController){
        this.viewController = ViewController;
        spielerA1 = new Spieler(100,100);
        spielerA2 = new Spieler(100,200);
        spielerA3 = new Spieler(100,300);
        spielerB1 = new Spieler(400,100);
        spielerB2 = new Spieler(400,200);
        spielerB3 = new Spieler(400,300);
        ball = new Ball(200, 200);
        torA = new Tor(ball);
        torB = new Tor(ball);
        mannschaftA = new Mannschaft(ball);
        mannschaftB = new Mannschaft(ball);
        bankA = new Bank(mannschaftA);
        bankB = new Bank(mannschaftB);
        investoren = new Investoren[2][3];


        //--------------------------------------------------------------------
        fillTeams();
        fillInvestors();
        mannschaftA.changePlayer();
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        viewController.showScene(3);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Achtung: funktioniert nicht im Szenario-Modus
     */
    public void startProgram() {
        viewController.draw(mannschaftA,3);
        viewController.draw(mannschaftB,3);
        viewController.draw(ball,3);
    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     *
     *           if(viewController.isKeyDown(KeyEvent.VK_UP)){
     *             System.out.println("Moin");
     *         }
     */
    public void updateProgram(double dt){
        bankA.heileDieSpieler();
        bankB.heileDieSpieler();
        mannschaftA.auswecheln(bankA.getBank(),bankA);
        pruefeSchussFuerAlleSpieler(mannschaftA.getMannschaft(),dt);
        pruefeSchussFuerAlleSpieler(mannschaftB.getMannschaft(),dt);
    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird einmalig aufgerufen für jedes Mal, wenn die Maus im Fenster geklickt wird.
     * @param e Das übergebene Objekt enthält alle Informationen zum MouseEvent
     */
    public void mouseClicked(MouseEvent e){


    }

    /**
     * Die Methode dient zur auffüllung der Bänke und der Mannschaften.
     */
    public void fillTeams(){
        for(int i = 0; i <10;i++){
            if (i < 3){
                mannschaftA.fillTheTeam(new Spieler(Math.random()*300+10,Math.random()*100+10));
                mannschaftB.fillTheTeam(new Spieler(Math.random()*300+10,Math.random()*100+10));
            }else{
                bankA.fillTheTeam(new Spieler(Math.random()*300+10,Math.random()*100+10));
                bankB.fillTheTeam(new Spieler(Math.random()*300+10,Math.random()*100+10));
            }
        }
    }

    /**
     * Die Methode dient zur auffüllung des Investoren-Arrays.
     */
    public void fillInvestors(){
        for (int i = 0; i<investoren.length;i++){
            for (int j = 0; j < investoren[i].length;j++){
                investoren[i][j] = new Investoren(mannschaftA,mannschaftB);
            }
        }
    }

    /**
     *
     * @param m die übergebene MAnnschaft, deren alle Spieler auf eine BAllkollision überprüft werden
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void pruefeSchussFuerAlleSpieler(List<Spieler> m,double dt){
        m.toFirst();
        while(m.hasAccess()){
            schussKollision(m.getContent(),ball,dt);
            m.next();
        }
    }
    /**
     *
     * @param spieler ein Spieler,der den Ball wegschießt
     * @param ball ein BAll, der in den Winkel abgeschossen wird, wie ihn der Spieler trifft
     *            und nach einer Weile langsamer wird
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void schussKollision(Spieler spieler,Ball ball,double dt){
        // Der Abstand in X-(horizontal) und Y-Richtung(vertikal) wird festgelegt
        double dx=spieler.getX()-ball.getX();
        double dy=spieler.getY()-ball.getY();
        //Die Hypothenuse des rechtwinkligen Dreiecks mit dx und dy als Katheten widr festgelegt
        double hypothenuse=Math.sqrt(Math.pow(dx,2)+ Math.pow(dy,2));
        //Die Radien der Kreisobjekte werden festgelegt
        double rs=spieler.getWidth();
        double rb=ball.getWidth();
        //Falls Objekte sich berühren, berechne für X und Y Richtung die neuen GEschwindigkeiten,
        // falls die Hypothnuse den Wert 1 hätte und
        // man diese mit der Geschwindigkeit des Spielers(und mehr) verfielfachen würde
        if(hypothenuse<(rb+rs)/2){
            ball.setVx(-dx/hypothenuse*spieler.getSpeed()*1.5);
            ball.setVy(-dy/hypothenuse*spieler.getSpeed()*1.5);
        }else {
            //Sonst: Lasse den Ball langsamer werden, bis er stoppt.
            // Hier müssen die Fälle beachtet werden,
            // dass die Gerschwindigkeit, je nach Richtung, negativ sein kann.
            if(ball.getVx()!=0) {
                ball.setVx(ball.getVx() - 20 * ball.getVx() / Math.abs(ball.getVx())* dt);
            }
            if(ball.getVy()!=0) {
                ball.setVy(ball.getVy() - 20 * ball.getVy() / Math.abs(ball.getVy())* dt );
            }
        }

    }

}
