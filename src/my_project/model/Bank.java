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
     * Dies dient zur vereinfachung des heilens aller Spieler. Danach wird geschaut wie oft maximal geheilt werden muss.
     * Solange man einen nicht vollständig geheilten Spieler hat und der schwächste nicht vollständig geheilt ist, wird
     * der aktuelle Spieler um einen Ausdauerpunkt geheilt und dann ist der nächste dran.
     * Man beachte beim betrachten auf die Methode recharge vom Spieler.
     */
    public void heileDieSpieler(){
        int tmp = anzahlSpieler;
        List<Spieler> bench = new List<>();
        while (tmp !=0){
            bench.append(bank.front());
            bank.enqueue(bank.front());
            bank.front();
            tmp--;
        }
        bench.toFirst();
        Spieler player = bench.getContent();
        bench.next();
        while (bench.hasAccess()){
            if (player.getStamina() > bench.getContent().getStamina()){
                player = bench.getContent();
            }
            bench.next();
        }
        bench.toFirst();
        while (player != null && player.getStamina() != 100){
            bench.getContent().recharge();
            bench.next();
        }
    }
}
