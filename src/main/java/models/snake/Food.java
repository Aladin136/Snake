package models.snake;

public class Food extends Point {
    public Food(int x, int y) {
        super(x, y);
        this.color = FOOD_COLOR;
    }

    public void eat(){
        int x, y;
        do {
            x = random.nextInt(FIELD_WIDTH);
            y = random.nextInt(FIELD_HEIGHT);
        } while (false);
//        (snake.isInsideSnake(x, y));
        this.setXY(x, y);
    }

    public boolean isEating() {
        return this.getX() == -1;
    }

    public void next() {

    }

}