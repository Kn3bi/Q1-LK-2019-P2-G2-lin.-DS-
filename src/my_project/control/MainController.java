package my_project.control;

public class MainController {

    //private ProgramController programmCon; WO WIRD DAS DING ERZEUGT???!??!?!
    private SoundController soundCon;
    private ViewController viewCon;
    private StrukturController strukturCon;

    public MainController(){
        new MainController();
        viewCon = new ViewController();
        strukturCon = new StrukturController();
        soundCon = new SoundController();
    }
}
