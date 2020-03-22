package my_project.control;

import KAGO_framework.view.DrawTool;
import my_project.view.*;


public class ViewController {
    private AnleitungsView anleitungsV;
    private SpielView spielV;
    private StartView startV;
    private ZeitView zeitV;
    private EndeView endView;

    public ViewController(){
        anleitungsV = new AnleitungsView();
        spielV = new SpielView();
        startV = new StartView();
        zeitV = new ZeitView();
        endView = new EndeView();
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

    public EndeView getEndView() {
        return endView;
    }
}
