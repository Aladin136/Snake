package models.snake;

import main.GameSnake;

import java.awt.*;

public class OneCellPoint extends GameSnake {
    int x, y;
    Color color = DEFAULT_COLOR;

    public OneCellPoint(int x, int y) {
        this.setXY(x, y);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
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

    @Override
    public String toString() {
        return this.x + ":" + this.y + " " + this.color ;
    }
}
