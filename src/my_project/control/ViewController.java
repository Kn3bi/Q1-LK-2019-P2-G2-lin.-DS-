package my_project.control;

import KAGO_framework.view.DrawTool;
import my_project.view.AnleitungsView;
import my_project.view.SpielView;
import my_project.view.StartView;
import my_project.view.ZeitView;

public class ViewController {
    private AnleitungsView anleitungsV;
    private SpielView spielV;
    private StartView startV;
    private ZeitView zeitV;

    public ViewController(){
        anleitungsV = new AnleitungsView();
        spielV = new SpielView();
        startV = new StartView();
        zeitV = new ZeitView();
    }

    public SpielView getSpielV() {
        return spielV;
    }

    public AnleitungsView getAnleitungsV() {
        return anleitungsV;
    }

    public StartView getStartV() {
        return startV;
    }

    public ZeitView getZeitV() {
        return zeitV;
    }
}
