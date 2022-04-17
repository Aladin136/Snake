package models.snake;

import main.GameSnake;

import java.awt.*;
import java.util.Random;

public class Point extends GameSnake {
    Random random = new Random();
    int x, y;
    Color color = DEFAULT_COLOR;

    public Point(int x, int y) {
        this.setXY(x, y);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }

    public  int getRandomX(){
        return random.nextInt(FIELD_WIDTH - 1);
    }

    public int[] getRandomXY() {
        return new int[]{random.nextInt(FIELD_WIDTH - 1), random.nextInt(FIELD_HEIGHT - 1)};
    }

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
