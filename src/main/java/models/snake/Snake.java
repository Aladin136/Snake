package models.snake;

import enums.Sides;
import main.GameSnake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Snake extends GameSnake {
    ArrayList<OneCellPoint> snakePoints = new ArrayList<>();
    Sides direction;

    public Snake(int x, int y, int length, Sides direction) {
        for (int i = 0; i < length; i++) {
            OneCellPoint point = new OneCellPoint(x, y);
            snakePoints.add(point);
        }
        this.direction = direction;
    }

    boolean isFood(List<Food> foodList) {
        for(Food food : foodList) {
            if ((snakePoints.get(0).getX() == food.getX()) && (snakePoints.get(0).getY() == food.getY())){
                food.eat();
                return true;
            }
        }
        return false;
    }

    protected int getHeadSnakeX(){
        return snakePoints.get(0).getX();
    }

    protected int getHeadSnakeY(){
        return snakePoints.get(0).getY();
    }

    public List<OneCellPoint> getPointsList(){
        return this.snakePoints;
    }

    public Sides getDirection(){
        return this.direction;
    }
    public void setDirection(Sides direction){
            if (this.direction == Sides.LEFT && direction != Sides.RIGHT){
                this.direction = direction;
            }
            if (this.direction == Sides.UP && direction != Sides.DOWN){
                this.direction = direction;
            }
            if (this.direction == Sides.RIGHT && direction != Sides.LEFT){
                this.direction = direction;
            }
            if (this.direction == Sides.DOWN && direction != Sides.UP){
                this.direction = direction;
            }
    }

    public OneCellPoint getHead() {
        return snakePoints.get(0);
    }

    public void move() {
        int x = snakePoints.get(0).getX();
        int y = snakePoints.get(0).getY();

        if (AUTOPILOT){
            this.setDirection(0);
        }

        switch (direction){
            case UP -> y--;
            case DOWN -> y++;
            case LEFT -> x--;
            case RIGHT -> x++;
        }

        if (DEATH_BOARDS){
            if (x > FIELD_WIDTH - 1) {GAME_OVER = true;}
            if (x < 0) {GAME_OVER = true;}
            if (y > FIELD_HEIGHT - 1) {GAME_OVER = true;}
            if (y < 0) {GAME_OVER = true;}
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
        if (isFood(foodList)) {
            frame.setTitle(TITLE_OF_PROGRAM + " : " + snakePoints.size());
        } else {
            snakePoints.remove(snakePoints.size() - 1);
        }

    }

    public void setDirection(int keyKode) {
        if ((keyKode >= 37 && keyKode <= 40) ||
                ((keyKode == 65)||(keyKode == 87)||(keyKode == 68)||(keyKode == 83))) {
            switch (keyKode){
                case 37, 65 -> {
                    if (direction != Sides.RIGHT){
                        direction = Sides.LEFT;
                    }
                }
                case 38, 87 -> {
                    if (direction != Sides.DOWN){
                        direction = Sides.UP;
                    }
                }
                case 39, 68 -> {
                    if (direction != Sides.LEFT){
                        direction = Sides.RIGHT;
                    }
                }
                case 40, 83 -> {
                    if (direction != Sides.UP){
                        direction = Sides.DOWN;
                    }
                }
            }
        }
    }

    public void paint(Graphics g) {
        try {
            for (OneCellPoint point : snakePoints) {
                point.paint(g);
            }
        } catch (Exception ignored){
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
