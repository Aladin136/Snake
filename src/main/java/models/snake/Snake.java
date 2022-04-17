package models.snake;

import settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake extends Settings {
    ArrayList<Point> snakePoints = new ArrayList<>();
    int direction;

    public Snake(int x, int y, int length, int direction) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x - i, y);
            snakePoints.add(point);
        }
        this.direction = direction;
    }

    boolean isFood(Point food) {
        return (snakePoints.get(0).getX() == food.getX()) && (snakePoints.get(0).getY() == food.getY());
    }

    public void move(Food food, JFrame frame, Snake snake) {
        int x = snakePoints.get(0).getX();
        int y = snakePoints.get(0).getY();
        if (direction == LEFT) {x--;}
        if (direction == RIGHT) {x++;}
        if (direction == UP) {y--;}
        if (direction == DOWN) {y++;}

        if (x > FIELD_WIDTH - 1) {x = 0;}
        if (x < 0) {x = FIELD_WIDTH - 1;}
        if (y > FIELD_HEIGHT - 1) {y = 0;}
        if (y < 0) {y = FIELD_HEIGHT - 1;}

        if (CHECK_FOR_ACROSS){
            if (isInsideSnake(x, y)){
                GAME_OVER = true;
                System.out.println("GAME_OVER");
                System.out.println(GAME_OVER);
            }

        }

        snakePoints.add(0, new Point(x,y));
        if (isFood(food)) {
            food.eat(snake);
            frame.setTitle(TITLE_OF_PROGRAM + " : " + snakePoints.size());
        } else {
            snakePoints.remove(snakePoints.size()-1);
        }


    }

    public void setDirection(int direction) {
        if (direction >=LEFT && direction <= DOWN) {
            if (direction == LEFT && this.direction != RIGHT){this.direction = direction;}
            if (direction == UP && this.direction != DOWN){this.direction = direction;}
            if (direction == RIGHT && this.direction != LEFT){this.direction = direction;}
            if (direction == DOWN && this.direction != UP){this.direction = direction;}
        }
    }

    public void paint(Graphics g) {
        for (Point point : snakePoints) {
            point.paint(g);
        }
    }

    int it;
    public boolean isInsideSnake(int x, int y) {
        it=0;
        for (Point point : snakePoints) {
            System.out.println(++it+")  ");
            if (x == point.getX()){
                if (y == point.getY()){

                    System.out.println("=======================================");
                }
            }
            if (point.getX() == x && point.getY() == y)
                System.out.println("truesssss");
                return true;
        }
        return false;
    }
}
