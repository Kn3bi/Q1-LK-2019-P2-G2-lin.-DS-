package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import my_project.model.TaubeNuesschen;

import java.awt.event.MouseEvent;

import static java.awt.event.MouseEvent.BUTTON1;


/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {
private ViewController viewController;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param ViewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController ViewController){
        this.viewController = ViewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Achtung: funktioniert nicht im Szenario-Modus
     */
    public void startProgram() {
        TaubeNuesschen taubeNuesschen1 = new TaubeNuesschen(100,200);
        viewController.draw(taubeNuesschen1);
        TaubeNuesschen taubeNuesschen2 = new TaubeNuesschen(200,200);
        viewController.draw(taubeNuesschen2);


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
    public void mouseClicked(MouseEvent e) {


        }

    }


