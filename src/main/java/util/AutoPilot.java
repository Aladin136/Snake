package util;

import enums.Sides;
import models.snake.Snake;

public class AutoPilot extends Snake {

    public AutoPilot(int x, int y, int length, Sides direction) {
        super(x, y, length, direction);
    }

    @Override
    public void setDirection(int keyKode) {
        int toX = food.getX();
        int toY = food.getY();

        if (toX - getHeadSnakeX() != 0){
            if (toX - getHeadSnakeX() > 0){
                setDirection(Sides.RIGHT);
            } else {
                setDirection(Sides.LEFT);
            }
        }

        if (toY - getHeadSnakeY() != 0){
            if (toY - getHeadSnakeY() > 0){
                setDirection(Sides.DOWN);
            } else {
                setDirection(Sides.UP);
            }
        }
    }
}
