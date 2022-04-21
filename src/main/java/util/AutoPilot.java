package util;

import enums.Sides;
import models.snake.Food;
import models.snake.OneCellPoint;
import models.snake.Snake;

public class AutoPilot extends Snake {

    public AutoPilot(int x, int y, int length, Sides direction) {
        super(x, y, length, direction);
    }

    @Override
    public void setDirection(int keyKode) {
        Food food;
        OneCellPoint snakeHead;
        int perSUM = 1000000;
        int toX = 10;
        int toY = 10;

        for (int i = 0; i < FOOD_AMOUNT; i++) {
            food = foodList.get(i);
            snakeHead = snake.getHead();
            int X = Math.abs(snakeHead.getX() - food.getX());
            int Y = Math.abs(snakeHead.getY() - food.getY());
            if (perSUM > X + Y){
                perSUM = X + Y;
                toX = food.getX();
                toY = food.getY();
            }
        }




        if (toX - getHeadSnakeX() != 0){
            if (toX - getHeadSnakeX() > 0){
                if (getDirection() != Sides.LEFT){
                    setDirection(Sides.RIGHT);
                }
            } else {
                if (getDirection() != Sides.RIGHT)
                setDirection(Sides.LEFT);
            }
        }

        if (toY - getHeadSnakeY() != 0){
            if (toY - getHeadSnakeY() > 0){
                if (getDirection() != Sides.UP){
                    setDirection(Sides.DOWN);
                }
            } else {
                if (getDirection() != Sides.DOWN){
                    setDirection(Sides.UP);
                }
            }
        }
    }
}
