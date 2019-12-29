package my_project.control;

public class MainController {

    private ProgramController programmCon;
    private SoundController soundCon;
    private ViewController viewCon;
    private StrukturController strukturCon;

    public MainController(){
        viewCon = new ViewController();
        strukturCon = new StrukturController();
        soundCon = new SoundController();
        //programmCon = new ProgramController(viewCon);
    }
}
