package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.*;
import my_project.model.Ball;
import my_project.model.Enemy;

public class Mannschaft2 {
    private Ball ball;
    private Queue<Enemy> mannschaftE;

    public Mannschaft2(Ball ball){
        mannschaftE = new Queue<>();
        this.ball = ball;
    }
    public void draw(DrawTool drawTool) {
mannschaftE.front();
        while(!mannschaftE.isEmpty()){
            mannschaftE.front().draw(drawTool);
            mannschaftE.dequeue();
        }
    }
    public void fuelleEnemies(Enemy enemy){
        mannschaftE.enqueue(enemy);
    }
    public void changeSpieler() {
        double midXBall = ball.getX();
        double midYBall = ball.getY();
    }
        public Enemy aktuSpieler(){
        return mannschaftE.front();
    }
}
