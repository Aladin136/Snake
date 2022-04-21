package util;

import models.snake.Food;
import settings.Settings;

import java.util.Random;

import static main.GameSnake.snake;


public class UtilForSnake extends Settings {
    Random random = new Random();
    int[] randomXY = new int[2];
    int randomX;
    int randomY;
    int COUNT;

    public int[] getRandomXY(){
        COUNT = 0;
        do {
            randomX = random.nextInt(FIELD_WIDTH);
            randomY = random.nextInt(FIELD_HEIGHT);
            COUNT++;
            if (COUNT > FOOD_AMOUNT+100){
                GAME_WINED = true;
                break;
            }
        } while (snake.isInsideSnake(randomX, randomY) || Food.isInsideFoodList(randomX, randomY));
        randomXY[0] = randomX;
        randomXY[1] = randomY;
        return randomXY;
    }

    public int getRandomX(){
        return random.nextInt(FIELD_WIDTH-1);
    }

    public int getRandomY(){
        return random.nextInt(FIELD_HEIGHT-1);
    }
}
