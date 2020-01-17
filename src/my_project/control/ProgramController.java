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
    private Bank bankA;
    private Bank bankB;
    private Investoren[][] investoren;
    private Ball ball;
    private Tor torA;
    private my_project.control.ViewController viewCon;
    private int scene;
    private boolean endZustand;
    private Mannschaft elfmeterA;
    private Mannschaft elfmeterB;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param ViewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController ViewController){
        this.viewController = ViewController;
        ball = new Ball(200, 200);
        torA = new Tor(ball);
        mannschaftA = new Mannschaft(ball);
        mannschaftB = new Mannschaft(ball);
        elfmeterA   = new Mannschaft(ball);
        elfmeterB   = new Mannschaft(ball);
        bankA = new Bank(mannschaftA);
        bankB = new Bank(mannschaftB);
        investoren = new Investoren[2][3];
        viewCon = new my_project.control.ViewController();
        scene = 0;
        endZustand = false;

        //--------------------------------------------------------------------
        fillTeams();
        fillInvestors();
        mannschaftA.changePlayer();
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        viewController.showScene(scene);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Achtung: funktioniert nicht im Szenario-Modus
     */
    public void startProgram() {
        viewController.draw(viewCon.getStartV(),0);
        viewController.draw(viewCon.getAnleitungsV(),1);
        viewController.draw(viewCon.getSpielV(),2);
        viewController.draw(viewCon.getZeitV(),2);
        viewController.draw(mannschaftA,2);
        viewController.draw(mannschaftB,2);
        viewController.draw(ball,2);
        viewController.draw(torA,2);
        viewController.draw(viewCon.getSpielV(),3);
        //viewController.draw(elfmeterA,3);
        //viewController.draw(elfmeterB,3);
        viewController.draw(viewCon.getEndView(),4);
    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){
        if (viewController.isKeyDown(KeyEvent.VK_0)){
            if (scene == 0){
                scene = 1;
                System.out.println(scene);
                viewController.showScene(scene);
            }
        }else if (viewController.isKeyDown(KeyEvent.VK_9)){
            if (scene == 0) {
                scene = 2;
                viewController.showScene(scene);
            }
        }else if (viewController.isKeyDown(KeyEvent.VK_1)){
            if (scene == 1 || scene == 3) {
                scene = 0;
                viewController.showScene(scene);
            }
        }else if (viewCon.getZeitV().getZeit()>30){
            if (scene == 2) {
                scene = 3;
                viewController.showScene(scene);
            }
        }else if (endZustand){
            if (scene==2 || scene == 3){
                scene = 4;
                viewController.showScene(scene);
            }
        }

        if(scene == 2) {
            bankA.heileDieSpieler();
            bankB.heileDieSpieler();
            mannschaftA.auswecheln(bankA.getBank(), bankA);
            pruefeSchussFuerAlleSpieler(mannschaftA.getMannschaft(), dt);
            pruefeSchussFuerAlleSpieler(mannschaftB.getMannschaft(), dt);
            if (viewController.isKeyDown(KeyEvent.VK_RIGHT)) {
                mannschaftA.getMannschaft().toFirst();
                mannschaftA.getAktSpieler().setX(mannschaftA.getAktSpieler().getX() + mannschaftA.getAktSpieler().getSpeed() * dt);
            }
            if (viewController.isKeyDown(KeyEvent.VK_LEFT)) {
                mannschaftA.getMannschaft().toFirst();

                mannschaftA.getAktSpieler().setX(mannschaftA.getAktSpieler().getX() - mannschaftA.getAktSpieler().getSpeed() * dt);
            }
            if (viewController.isKeyDown(KeyEvent.VK_UP)) {
                mannschaftA.getMannschaft().toFirst();

                mannschaftA.getAktSpieler().setY(mannschaftA.getAktSpieler().getY() - mannschaftA.getAktSpieler().getSpeed() * dt);
            }
            if (viewController.isKeyDown(KeyEvent.VK_DOWN)) {
                mannschaftA.getMannschaft().toFirst();

                mannschaftA.getAktSpieler().setY(mannschaftA.getAktSpieler().getY() + mannschaftA.getAktSpieler().getSpeed() * dt);
            }

            if(viewController.isKeyDown(KeyEvent.VK_W)){
                mannschaftB.getAktSpieler().setY(mannschaftB.getAktSpieler().getY() - mannschaftB.getAktSpieler().getSpeed()*dt);
            }

        }
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
                mannschaftA.fillTheTeam(new Spieler(Math.random()*300+10,Math.random()*100+10,true));
            }else{
                bankA.fillTheTeam(new Spieler(Math.random()*300+10,Math.random()*100+10,true));
            }
        }
        for(int i = 0; i <10;i++){
            if (i < 3){
                mannschaftB.fillTheTeam(new Spieler(Math.random()*300+10,Math.random()*100+10,false));
            }else{
                bankB.fillTheTeam(new Spieler(Math.random()*300+10,Math.random()*100+10,false));
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
    public void setzeElfmeterSchuetze(List<Spieler>e,double dt){
            e.toFirst();
        if(mannschaftA.getAktSpieler().getStamina()>50 && mannschaftA.getAktSpieler().getIngame() ){
            mannschaftA.getAktSpieler().setElfertuechtig(true);

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
