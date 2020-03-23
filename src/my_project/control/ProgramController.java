package my_project.control;

import KAGO_framework.control.Drawable;
import KAGO_framework.control.ViewController;
import my_project.model.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute

    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Mannschaft mannschaftA;
    private Mannschaft2 mannschaftE;
    private Bank bankA;
    private schussStack schussS;
    private boolean schussA;
    private Ball ball;
    private my_project.control.ViewController viewCon;
    private int scene;
    private boolean endZustand;
    private int points1;
    private boolean puante;
    private int[][] agencyy = new int [3][3] ;
    private boolean gol= false;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param ViewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController ViewController){
        this.viewController = ViewController;
        ball = new Ball(70, 350);
        viewController.getSoundController().loadSound("assets/images/op1.wav","game",true);

        mannschaftA = new Mannschaft(ball);
        mannschaftE = new Mannschaft2(ball);
        schussS     = new schussStack();



        viewCon = new my_project.control.ViewController();
        scene = 0;
        endZustand = false;
        agencyy[0][0]= 10;
        agencyy[0][1]= 3;
        agencyy[0][2]= 4;
        agencyy[1][1]= 6;
        agencyy[2][1] = 3;
        agencyy[2][2] = 10;
        //--------------------------------------------------------------------
        fillTeam();

        mannschaftA.changePlayer();
        mannschaftE.changeSpieler();
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        viewController.showScene(scene);
        System.out.print(mannschaftE.getAktSpieler());
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Achtung: funktioniert nicht im Szenario-Modus
     */
    public void startProgram() {
        for(int i = 0;i<3;i++){
            for(int j=  0 ;j<3;j++){
                System.out.println(agencyy[i][j]);
            }
        }
        if(gol){
            for(int i = 0;i<(int)(Math.random()*2);i++) {
                for (int j = 0; j < (int) (Math.random() * 2); j++) {
                    if ((int) (Math.random() * 7) == agencyy[i][j]) {
                        points1+= agencyy[i][j];
                        endZustand = true;
                    }
                }

            }
        }

        viewController.draw(viewCon.getStartV(),0);
        viewController.draw(viewCon.getAnleitungsV(),1);
        viewController.draw(viewCon.getSpielV(),2);
        viewController.draw(viewCon.getZeitV(),2);
        viewController.draw(mannschaftA,2);
        viewController.draw( mannschaftE,2);

        viewController.draw(ball,2);

        viewController.draw(viewCon.getSpielV(),3);


        viewController.draw(viewCon.getEndView(),4);
        if(schussA){
            viewController.draw(schussS,2);
        }
    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){
        if(gol){
            for(int i = 0;i<(int)(Math.random()*2);i++) {
                for (int j = 0; j < (int) (Math.random() * 2); j++) {
                    if ((int) (Math.random() * 7) == agencyy[i][j]) {
                        points1+= agencyy[i][j];
                    }
                }

            }
        }
        if(gol&& !endZustand) {
            System.out.println(points1 + "   Pünktchen");
        }



        if (viewController.isKeyDown(KeyEvent.VK_0)){
            if (scene == 0){
                scene = 1;
                viewController.showScene(scene);
            }
        }else if (viewController.isKeyDown(KeyEvent.VK_9)){
            if (scene == 0) {
                scene = 2;
                viewController.showScene(scene);
            }
        }else if (viewController.isKeyDown(KeyEvent.VK_1)){
            if (scene == 1 || scene == 4) {
                scene = 0;
                viewController.showScene(scene);
            }

        }else if (endZustand){
            if (scene==2 || scene == 3){
                scene = 4;
                viewController.showScene(scene);
                if(points1 == 3){
                    System.out.println("Spieler 1 gewinnt, Ruffys tipico schein ist nicht aufgegangen");

                }else{
                    viewCon.getEndView().setSiegerSituation("Unentschieden");
                }
            }
        }




        if(scene == 2) {
            viewController.getSoundController().playSound("game");
            if(viewController.isKeyDown(KeyEvent.VK_Z)){

                schussA = true;
            }
                if(!mannschaftA.notEmpty()){
                     endZustand = true;
                }
            if (viewController.isKeyDown(KeyEvent.VK_G)&& mannschaftA.notEmpty()) {

                    mannschaftA.delete(mannschaftA.getAktSpieler());

            }
            fillMuni();
            pruefeSchussFuerAlleSpieler(mannschaftA.getMannschaft(), dt);
            SiegesKollision();
            if(points1==3){
                endZustand = true;
            }
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
                if(viewController.isKeyDown((KeyEvent.VK_W))){
                   // mannschaftE.getEnemy().front();
                    mannschaftE.getAktSpieler().setY(mannschaftE.getAktSpieler().getY()-mannschaftE.getAktSpieler().getSpeed()*dt);
                }
            if(viewController.isKeyDown((KeyEvent.VK_S))){
                // mannschaftE.getEnemy().front();
                mannschaftE.getAktSpieler().setY(mannschaftE.getAktSpieler().getY()+mannschaftE.getAktSpieler().getSpeed()*dt);
            }
            if(viewController.isKeyDown(KeyEvent.VK_A)){
                mannschaftE.getAktSpieler().setX(mannschaftE.getAktSpieler().getX()-mannschaftE.getAktSpieler().getSpeed()*dt);
            }
            if(viewController.isKeyDown(KeyEvent.VK_D)){
                mannschaftE.getAktSpieler().setX(mannschaftE.getAktSpieler().getX()+mannschaftE.getAktSpieler().getSpeed()*dt);
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
    public void fillTeam(){
        for(int i = 0; i <3;i++) {

            mannschaftA.fillTheTeam(new Spieler(Math.random() * 300 + 10, Math.random() * 100 + 10, true));
            mannschaftE.fuelleEnemies(new Enemy(Math.random()*400+300,Math.random()*200+10));
        }

    }

    public void fillMuni(){

        for(int i = 0;i <20;i++){
            schussS.fillMunis(new Schuss(mannschaftE.getAktSpieler().getX(),mannschaftE.getAktSpieler().getY()));
        }
    }


    /**
     * Die Methode dient zur auffüllung des Investoren-Arrays.
     */




    /**
     *Die Methode prüft, ob ein Spieler aus eiener Mannschaft mit dem Ball kollidiert.
     * Dies wird mit jedem Spieler der AMnnschaft gemacht.
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
     *In dieser Methode wird geschaut,ob ein Spieler,der sich im Spiel befindet als Elfmeterspieler eignet.
     * Falls dies der Fall ist, wird das Attribut auf true gesetzt.
     * @param e eine Liste, die Spieler beinhaltet
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
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
        double dx=(spieler.getX())-ball.getX();
        double dy=(spieler.getY())-ball.getY();
        //Die Hypothenuse des rechtwinkligen Dreiecks mit dx und dy als Katheten widr festgelegt
        double hypothenuse=Math.sqrt(Math.pow(dx,2)+ Math.pow(dy,2));
        //Die Radien der Kreisobjekte werden festgelegt
        double rs=spieler.getRadius();
        double rb=ball.getRadius();

        //Falls Objekte sich berühren, berechne für X und Y Richtung die neuen GEschwindigkeiten,
        // falls die Hypothnuse den Wert 1 hätte und
        // man diese mit der Geschwindigkeit des Spielers(und mehr) verfielfachen würde
        if(hypothenuse<((rb+rs)/2)){
            ball.setVx(-dx/hypothenuse*spieler.getSpeed()*2);
            ball.setVy(-dy/hypothenuse*spieler.getSpeed()*2);
        }else {
            //Sonst: Lasse den Ball langsamer werden, bis er stoppt.
            // Hier müssen die Fälle beachtet werden,
            // dass die Gerschwindigkeit, je nach Richtung, negativ sein kann.
            if(ball.getVx()!=0) {
                ball.setVx(ball.getVx() - 10 * ball.getVx() / Math.abs(ball.getVx())* dt);
            }
            if(ball.getVy()!=0) {
                ball.setVy(ball.getVy() - 10 * ball.getVy() / Math.abs(ball.getVy())* dt );
            }
        }

    }
    public void SiegesKollision() {
        if (ball.getX() > 1000) {
            ball.setX(500);
            points1++;
            gol = true;

        }
    }



    public void schussKollisionE(Enemy enemy,Ball ball,double dt){
        // Der Abstand in X-(horizontal) und Y-Richtung(vertikal) wird festgelegt
        double dx=(enemy.getX())-ball.getX();
        double dy=(enemy.getY())-ball.getY();
        //Die Hypothenuse des rechtwinkligen Dreiecks mit dx und dy als Katheten widr festgelegt
        double hypothenuse=Math.sqrt(Math.pow(dx,2)+ Math.pow(dy,2));
        //Die Radien der Kreisobjekte werden festgelegt
        double rs=enemy.getRadius();
        double rb=ball.getRadius();

        //Falls Objekte sich berühren, berechne für X und Y Richtung die neuen GEschwindigkeiten,
        // falls die Hypothnuse den Wert 1 hätte und
        // man diese mit der Geschwindigkeit des Spielers(und mehr) verfielfachen würde
        if(hypothenuse<((rb+rs)/2)){
            ball.setVx(-dx/hypothenuse*enemy.getSpeed()*2);
            ball.setVy(-dy/hypothenuse*enemy.getSpeed()*2);
        }else {
            //Sonst: Lasse den Ball langsamer werden, bis er stoppt.
            // Hier müssen die Fälle beachtet werden,
            // dass die Gerschwindigkeit, je nach Richtung, negativ sein kann.
            if(ball.getVx()!=0) {
                ball.setVx(ball.getVx() - 10 * ball.getVx() / Math.abs(ball.getVx())* dt);
            }
            if(ball.getVy()!=0) {
                ball.setVy(ball.getVy() - 10 * ball.getVy() / Math.abs(ball.getVy())* dt );
            }
        }

    }



        }


