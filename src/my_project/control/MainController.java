package my_project.control;

public class MainController {

    //private ProgramController programmCon; WO WIRD DAS DING ERZEUGT???!??!?!
    private SoundController soundCon;
    private StrukturController strukturCon;

    public MainController(){
        new MainController();
        strukturCon = new StrukturController();
        soundCon = new SoundController();
    }
}
