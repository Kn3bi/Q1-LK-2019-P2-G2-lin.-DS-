package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.DrawTool;

public class Mannschaft2 {
    private Ball ball;
    private Queue<Enemy> mannschaftE;

    public Mannschaft2(Ball ball){
        mannschaftE = new Queue<>();
        this.ball = ball;
    }
    public void draw(DrawTool drawTool) {

        while(!mannschaftE.isEmpty()){
            mannschaftE.front().draw(drawTool);
            mannschaftE.dequeue();
        }
    }
    public void fuelleEnemies(Enemy enemy){
        mannschaftE.enqueue(enemy);
    }
}
