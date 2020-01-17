package my_project.control;

public class MainController {

    //private ProgramController programmCon; WO WIRD DAS DING ERZEUGT???!??!?!
    private SoundController soundCon;

    public MainController(){
        new MainController();
        soundCon = new SoundController();
    }
}
