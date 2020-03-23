package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.view.DrawTool;

public class schussStack extends GraphicalObject {
    private Stack<Schuss> schussS;

    public schussStack() {
        schussS = new Stack<>();
    }

    @Override
    public void draw(DrawTool drawTool) {
        Schuss s = schussS.top();

        schussS.top().draw(drawTool);
        schussS.push(schussS.top());
        schussS.pop();

        while (schussS.top() != s) {
            schussS.top().draw(drawTool);
            schussS.push(schussS.top());
            schussS.pop();

        }
    }
        @Override
        public void update ( double dt){
        }
    public Schuss getLastSchuss(){
        return schussS.top();
    }
    public void fillMunis(Schuss schuss){
        schussS.push(schuss);

    }
    }
