package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.*;

import java.awt.event.MouseEvent;

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
        torA = new Tor();
        torB = new Tor();
        ball = new Ball(torA, torB, 200, 200);
        mannschaftA = new Mannschaft(ball);
        mannschaftB = new Mannschaft(ball);
        bankA = new Bank();
        bankB = new Bank();
        investoren = new Investoren[2][3];
        //--------------------------------------------------------------------
        fillTeams();
        fillInvestors();
        mannschaftA.changePlayer();
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Achtung: funktioniert nicht im Szenario-Modus
     */
    public void startProgram() {
        viewController.draw(mannschaftA);
        viewController.draw(mannschaftB);
        viewController.draw(ball);
    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){


    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird einmalig aufgerufen für jedes Mal, wenn die Maus im Fenster geklickt wird.
     * @param e Das übergebene Objekt enthält alle Informationen zum MouseEvent
     */
    public void mouseClicked(MouseEvent e){


    }

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

    public void fillInvestors(){
        for (int i = 0; i<investoren.length;i++){
            for (int j = 0; j < investoren[i].length;j++){
                investoren[i][j] = new Investoren(mannschaftA,mannschaftB);
            }
        }
    }

}
