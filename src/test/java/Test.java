//import main.GameSnake;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.util.ArrayList;
//import java.util.Random;
//
//public class Test {
//    final String TITLE_OF_PROGRAM = "Classic Game Snake";
//    final String GAME_OVER_MSG = "GAME OVER";
//    final int POINT_RADIUS = 20; //in pix
//    final int FIELD_WIDTH = 30; //in point
//    final int FIELD_HEIGHT = 20; //in point
//    final int FIELD_DX = 0;
//    final int FIELD_DY = 20;
//    final int START_LOCATION = 200;
//    final boolean RESIZABLE = false;
//
//    final int START_SNAKE_SIZE = 8;
//    final int START_SNAKE_X = 10;
//    final int START_SNAKE_Y = 10;
//    final int START_SNAKE_DIRECTION = 39;
//    final int SHOW_DELAY = 150;
//
//    final int LEFT = 37;
//    final int UP = 38;
//    final int RIGHT = 39;
//    final int DOWN = 40;
//
//    final Color DEFAULT_COLOR = Color.BLACK;
//    final Color FOOD_COLOR = Color.GREEN;
//    final Color POISON_COLOR = Color.RED;
//    final Color BACKGROUND_COLOR = Color.WHITE;
//
//    Snake snake;
//    Food food;
//    //    Poison poison;
//    JFrame frame;
//    Canvas canvasPanel;
//    Random random = new Random();
//    boolean gameOver = false;
//
//    boolean CHECK_FOR_ACROSS = true;
//
//    public static void main(String[] args) {
//        new GameSnake().go();
//    }
//
//    void go() {
//        snake = new Snake(START_SNAKE_X, START_SNAKE_Y,
//                START_SNAKE_SIZE, START_SNAKE_DIRECTION);
//        food = new Food();
//
//        frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX,
//                FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
//        frame.setLocation(START_LOCATION, START_LOCATION);
//        frame.setResizable(RESIZABLE);
//
//        canvasPanel = new Canvas();
//        canvasPanel.setBackground(BACKGROUND_COLOR);
//
//        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
//        frame.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                snake.setDirection(e.getKeyCode());
//            }
//        });
//
//        frame.setVisible(true);
//
//        while (!gameOver) {
//            snake.move();
//            if (food.isEating()){
//                food.next();
//            }
//            canvasPanel.repaint();
//            try {
//                Thread.sleep(SHOW_DELAY);
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//    class Snake {
//        ArrayList<Point> snake = new ArrayList<>();
//        int direction;
//
//        public Snake(int x, int y, int length, int direction) {
//            for (int i = 0; i < length; i++) {
//                Point point = new Point(x - i, y);
//                snake.add(point);
//            }
//            this.direction = direction;
//        }
//
//        boolean isFood(Point food) {
//            return (snake.get(0).getX() == food.getX()) && (snake.get(0).getY() == food.getY());
//        }
//
//        void move() {
//            int x = snake.get(0).getX();
//            int y = snake.get(0).getY();
//            if (direction == LEFT) {x--;}
//            if (direction == RIGHT) {x++;}
//            if (direction == UP) {y--;}
//            if (direction == DOWN) {y++;}
//
//            if (x > FIELD_WIDTH - 1) {x = 0;}
//            if (x < 0) {x = FIELD_WIDTH - 1;}
//            if (y > FIELD_HEIGHT - 1) {y = 0;}
//            if (y < 0) {y = FIELD_HEIGHT - 1;}
//
//            if (CHECK_FOR_ACROSS){
//                gameOver = isInsideSnake(x, y);
//            }
//
//            snake.add(0, new Point(x,y));
//            if (isFood(food)) {
//                food.eat();
//                frame.setTitle(TITLE_OF_PROGRAM + " : " + snake.size());
//            } else {
//                snake.remove(snake.size()-1);
//            }
//
//
//        }
//
//        void setDirection(int direction) {
//            if (direction >=LEFT && direction <= DOWN) {
//                if (direction == LEFT && this.direction != RIGHT){this.direction = direction;}
//                if (direction == UP && this.direction != DOWN){this.direction = direction;}
//                if (direction == RIGHT && this.direction != LEFT){this.direction = direction;}
//                if (direction == DOWN && this.direction != UP){this.direction = direction;}
//            }
//        }
//
//        void paint (Graphics g) {
//            for (Point point : snake) {
//                point.paint(g);
//            }
//        }
//
//        public boolean isInsideSnake(int x, int y) {
//            for (Point point : snake) {
//                if (point.getX() == x && point.getY() == y)
//                    return true;
//            }
//            return false;
//        }
//    }
//
//    class Food extends Point {
//
//        public Food() {
//            super(random.nextInt(0, FIELD_WIDTH-1), random.nextInt(0, FIELD_HEIGHT-1));
//            this.color = FOOD_COLOR;
//        }
//
//        void eat(){
//            this.setXY(-1, -1);
//        }
//
//        boolean isEating() {
//            return this.getX() == -1;
//        }
//
//        void next() {
//            int x, y;
//            do {
//                x = random.nextInt(FIELD_WIDTH);
//                y = random.nextInt(FIELD_HEIGHT);
//            } while (snake.isInsideSnake(x, y));
//            this.setXY(x, y);
//        }
//    }
//
//    class Point {
//        int x, y;
//        Color color = DEFAULT_COLOR;
//
//        public Point(int x, int y) {
//            this.setXY(x, y);
//        }
//
//        void paint(Graphics g) {
//            g.setColor(color);
//            g.fillOval(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
//        }
//
//        void setXY(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public int getX() {
//            return x;
//        }
//
//        public int getY() {
//            return y;
//        }
//    }
//
//    public class Canvas extends JPanel {
//        @Override
//        public void paint(Graphics g) {
//            super.paint(g) ;
//            snake.paint(g);
//            food.paint(g);
//            if (gameOver) {
//                g.setColor(Color.RED);
//                g.setFont(new Font("Arial", Font.BOLD, 40));
//                FontMetrics fontMetrics = g.getFontMetrics();
////                g.drawString(GAME_OVER_MSG, (FIELD_WIDTH * POINT_RADIUS + FIELD_DX - fontMetrics.stringWidth(GAME_OVER_MSG)));
//            }
//        }
//    }
//}