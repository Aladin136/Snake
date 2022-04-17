package models.snake;

import enums.Sides;
import main.GameSnake;

import java.awt.*;
import java.util.ArrayList;

public class Snake extends GameSnake {
    ArrayList<OneCellPoint> snakePoints = new ArrayList<>();
    Sides direction;

    public Snake(int x, int y, int length, Sides direction) {
        for (int i = 0; i < length; i++) {
            OneCellPoint point = new OneCellPoint(x - i, y);
            snakePoints.add(point);
        }
        this.direction = direction;
    }

    boolean isFood(Food food) {
        return (snakePoints.get(0).getX() == food.getX()) && (snakePoints.get(0).getY() == food.getY());
    }

    public void move() {
        int x = snakePoints.get(0).getX();
        int y = snakePoints.get(0).getY();
        switch (direction){
            case UP -> y--;
            case DOWN -> y++;
            case LEFT -> x--;
            case RIGHT -> x++;
        }
//        if (direction == LEFT) {x--;}
//        if (direction == RIGHT) {x++;}
//        if (direction == UP) {y--;}
//        if (direction == DOWN) {y++;}

        if (DEATH_BOARDS){
            GAME_OVER = true;
        } else {
            if (x > FIELD_WIDTH - 1) {x = 0;}
            if (x < 0) {x = FIELD_WIDTH - 1;}
            if (y > FIELD_HEIGHT - 1) {y = 0;}
            if (y < 0) {y = FIELD_HEIGHT - 1;}
        }

        if (CHECK_FOR_ACROSS){
            GAME_OVER = isInsideSnake(x, y);
        }

        snakePoints.add(0, new OneCellPoint(x,y));
        if (isFood(food)) {
            food.eat();
            frame.setTitle(TITLE_OF_PROGRAM + " : " + snakePoints.size());
        } else {
            snakePoints.remove(snakePoints.size()-1);
        }


    }

    public void setDirection(int keyKode) {
        if ((keyKode >= 37 && keyKode <= 40) ||
                ((keyKode == 65)||(keyKode == 87)||(keyKode == 68)||(keyKode == 83))) {
            switch (keyKode){
                case 37, 65 -> direction = Sides.LEFT;
                case 38, 87 -> direction = Sides.UP;
                case 39, 68 -> direction = Sides.RIGHT;
                case 40, 83 -> direction = Sides.DOWN;
            }
        }
    }

    public void paint(Graphics g) {
        for (OneCellPoint point : snakePoints) {
            point.paint(g);
        }
    }

    public boolean isInsideSnake(int x, int y) {
        for (OneCellPoint point : snakePoints) {
            if (point.getX() == x && point.getY() == y)
                return true;
        }
        return false;
    }
}
