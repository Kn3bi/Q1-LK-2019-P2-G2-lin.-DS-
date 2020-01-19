package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;

public class Bank {

    private Queue<Spieler> bank;
    private Mannschaft mannschaft;
    private int anzahlSpieler;

    public Bank(Mannschaft mannschaft){
       bank = new Queue<>();
       this.mannschaft = mannschaft;
       anzahlSpieler = 0;
    }

    /**
     * Die Methode dient zur auffüllung der Bank von außerhalb. Außerdem werden gezählt wie viele auf der Bank sind.
     * Außerdem werden Spieler in das Stack, welches für das Elfmeter wichtig werden in das Stack getan.
     */
    public void fillTheTeam(Spieler spieler){
        bank.enqueue(spieler);
        anzahlSpieler++;
    }

    public Spieler getAktSpieler(){
        return bank.front();
    }

    public Queue getBank(){
        return bank;
    }

    /**
     * Die Methode dient dazu einen Spieler aus der Queue in die Mannschaftsliste zu tun und diesen dann zu entfernen.
     */
    public void runterVonDerBank(){
        if (!bank.isEmpty()) {
            mannschaft.fillTheTeam(bank.front());
            bank.dequeue();
        }
    }

    /**
     * Die Methode dient zur Heilung der Spieler. Dort werden alle vorhandenen Spieler in eine Liste getan.
     * Dies dient zur vereinfachung des Heilens aller Spieler. Falls man Zugriff auf die Liste hat,
     * wird der Spieler geheilt (nur wenn stamina nicht 100 ist (siehe recharge)) und dann wird der nächste betrachtet.
     */
    public void heileDieSpieler(){
        int tmp = anzahlSpieler;
        List<Spieler> bench = new List<>();
        while (tmp !=0){
            bench.append(bank.front());
            bank.enqueue(bank.front());
            bank.dequeue();
            bank.front();
            tmp--;
        }
        bench.toFirst();
        while (bench.hasAccess()){
            bench.getContent().recharge();
            bench.next();
        }
    }
}
