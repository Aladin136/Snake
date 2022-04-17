package settings;

import enums.Sides;

import java.awt.*;

public class Settings {
    public static final String TITLE_OF_PROGRAM = "Classic Game Snake";
    public static final String GAME_OVER_MSG = "GAME OVER";
    public static final int POINT_RADIUS = 20; //in pix
    public static final int FIELD_WIDTH = 30; //in point
    public static final int FIELD_HEIGHT = 20; //in point
    public static final int FIELD_DX = 0;
    public static final int FIELD_DY = 20;
    public static final int START_LOCATION = 200;

    public static final int START_SNAKE_SIZE = 8;
    public static final int START_SNAKE_X = 10;
    public static final int START_SNAKE_Y = 10;
    public static final Sides START_SNAKE_DIRECTION = Sides.RIGHT;

    public static final Color DEFAULT_COLOR = Color.BLACK;
    public static final Color FOOD_COLOR = Color.GREEN;
    public static final Color POISON_COLOR = Color.RED;
    public static final Color BACKGROUND_COLOR = Color.WHITE;

    public static final int SHOW_DELAY = 20;
    public static boolean RESIZABLE = false;
    public static boolean GAME_OVER;
    public static boolean CHECK_FOR_ACROSS = false;
    public static boolean DEATH_BOARDS = false;
    public static boolean AUTOPILOT = true;




}
