package my_project.model;

public class Spieler {

    private int speed;
    private int stamina;

    public Spieler(){
        speed = (int)(Math.random()*10+20);
        stamina = 100;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStamina() {
        return stamina;
    }

}
