package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.view.DrawTool;

public class Mannschaft extends GraphicalObject {

    private List<Spieler> mannschaft;

    public Mannschaft(){
        mannschaft = new List<>();

    }

    @Override
    public void draw(DrawTool drawTool) {

    }

    @Override
    public void update(double dt) {

    }

    public void fillTheTeam(Spieler spieler){
        mannschaft.append(spieler);
    }

    public List getMannschaft(){
        return mannschaft;
    }

    public Spieler getAktSpieler(){
        return mannschaft.getContent();
    }
}
