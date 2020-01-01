package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Stack;

public class Bank {

    private Stack<Spieler> bank;
    private Mannschaft mannschaft;
    private int anzahlSpieler;

    public Bank(Mannschaft mannschaft){
       bank = new Stack<>();
       this.mannschaft = mannschaft;
       anzahlSpieler = 0;
    }

    public void fillTheTeam(Spieler spieler){
        bank.push(spieler);
        anzahlSpieler++;
    }

    public Spieler getAktSpieler(){
        return bank.top();
    }

    public Stack getBank(){
        return bank;
    }

    public void runterVonDerBank(){
        mannschaft.fillTheTeam(bank.top());
        bank.pop();
    }

    public void heileDieSpieler(){
        int tmp = anzahlSpieler;
        List<Spieler> bench = new List<>();
        while (tmp !=0){
            bench.append(bank.top());
            bank.push(bank.top());
            bank.pop();
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
        while (player.getStamina() != 100){
            bench.getContent().recharge();
            bench.next();
        }
    }
}
