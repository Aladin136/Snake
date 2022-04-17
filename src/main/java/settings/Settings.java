package settings;

import java.awt.*;

public class Settings {
    public final String TITLE_OF_PROGRAM = "Classic Game Snake";
    public final String GAME_OVER_MSG = "GAME OVER";
    public final int POINT_RADIUS = 20; //in pix
    public final int FIELD_WIDTH = 30; //in point
    public final int FIELD_HEIGHT = 20; //in point
    public final int FIELD_DX = 0;
    public final int FIELD_DY = 20;
    public final int START_LOCATION = 200;

    public final int START_SNAKE_SIZE = 8;
    public final int START_SNAKE_X = 10;
    public final int START_SNAKE_Y = 10;
    public final int START_SNAKE_DIRECTION = 39;

    public final int LEFT = 37;
    public final int UP = 38;
    public final int RIGHT = 39;
    public final int DOWN = 40;

    public final Color DEFAULT_COLOR = Color.BLACK;
    public final Color FOOD_COLOR = Color.GREEN;
    public final Color POISON_COLOR = Color.RED;
    public final Color BACKGROUND_COLOR = Color.WHITE;

    public final int SHOW_DELAY = 350;
    public boolean RESIZABLE = false;
    public boolean GAME_OVER = false;
    public boolean CHECK_FOR_ACROSS = true;




}
