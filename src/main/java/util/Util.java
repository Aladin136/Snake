package util;

import settings.Settings;

import java.util.Random;


public class Util extends Settings {
    Random random = new Random();

    public int getRandomX(){
        return random.nextInt(FIELD_WIDTH-1);
    }

    public int getRandomY(){
        return random.nextInt(FIELD_HEIGHT-1);
    }
}
