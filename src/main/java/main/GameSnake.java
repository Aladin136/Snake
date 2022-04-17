package main;

import models.snake.Food;
import models.snake.Snake;
import settings.Settings;
import util.AutoPilot;
import util.UtilForSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameSnake extends Settings {

    public static Snake snake;
    public static Food food;
    //    Poison poison;
    public static JFrame frame;
    public static Canvas canvasPanel;
    public static Random random = new Random();
    public static UtilForSnake util = new UtilForSnake();

    public static void main(String[] args) {
        new GameSnake().go();
    }

    void go() {
        GAME_OVER = false;
        food = new Food(util.getRandomX(), util.getRandomY());
        if (AUTOPILOT){
            snake = new AutoPilot(START_SNAKE_X, START_SNAKE_Y,
                    START_SNAKE_SIZE, START_SNAKE_DIRECTION);
        } else {
            snake = new Snake(START_SNAKE_X, START_SNAKE_Y,
                    START_SNAKE_SIZE, START_SNAKE_DIRECTION);
        }


        frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((FIELD_WIDTH+1) * POINT_RADIUS + FIELD_DX,
                (FIELD_HEIGHT+1) * POINT_RADIUS + FIELD_DY);
        frame.setLocation(START_LOCATION, START_LOCATION);
        frame.setResizable(RESIZABLE);

        canvasPanel = new Canvas();
        canvasPanel.setBackground(BACKGROUND_COLOR);

        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });

        frame.setVisible(true);

        while (!GAME_OVER) {
            snake.move();
            if (food.isEating()){
                food.next();
            }
            canvasPanel.repaint();
            try {
                Thread.sleep(SHOW_DELAY);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g) ;
            snake.paint(g);
            food.paint(g);
            if (GAME_OVER) {
                g.setColor(Color.RED);
                g.setFont(new Font("Arial", Font.BOLD, 40));
                FontMetrics fontMetrics = g.getFontMetrics();
                g.drawString(GAME_OVER_MSG, (FIELD_WIDTH * POINT_RADIUS - fontMetrics.stringWidth(GAME_OVER_MSG))/2,
                        (FIELD_HEIGHT * POINT_RADIUS)/2);
            }
        }
    }
}