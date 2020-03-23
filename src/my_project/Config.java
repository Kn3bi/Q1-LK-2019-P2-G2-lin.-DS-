package my_project;

/**
 * In dieser Klasse werden globale, statische Einstellungen verwaltet.
 * Die Werte können nach eigenen Wünschen angepasst werden.
 */
public class Config {

    // Titel des Programms (steht oben in der Fenstertitelzeile)
    public final static String WINDOW_TITLE = "KUDHIHA BALLER LOS";

    // Breite des Programmfensters (Width) und Höhe des Programmfensters (Height)
    public final static int WINDOW_WIDTH = 1000;
    public final static int WINDOW_HEIGHT = 529;   // Effektive Höhe ist etwa 29 Pixel geringer (Titelleiste wird mitgezählt)

    // Weitere Optionen für das Projekt
    public final static boolean useSound = true; //Achtung: der SoundtController unterstützt momentan nicht alle Java-Versionen (nur bis Java 9)

}
