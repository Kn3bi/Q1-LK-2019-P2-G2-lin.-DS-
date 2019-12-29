package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.Stack;

public class Bank {

    private Stack<Spieler> bank;

    public Bank(){
       bank = new Stack<>();
    }

    public void fillTheTeam(Spieler spieler){
        bank.push(spieler);
    }

    public Spieler getAktSpieler(){
        return bank.top();
    }

    public Stack getBank(){
        return bank;
    }
}
