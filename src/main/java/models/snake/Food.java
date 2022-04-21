package models.snake;

public class Food extends OneCellPoint {
    public Food(int x, int y) {
        super(x, y);
        this.color = FOOD_COLOR;
    }

    public static boolean isInsideFoodList(int x, int y) {
        for (OneCellPoint point : foodList) {
            if (point.getX() == x && point.getY() == y)
                return true;
        }
        return false;
    }

    public void eat(){
        int[] XY = util.getRandomXY();
        this.setXY(XY[0], XY[1]);
    }

    public boolean isEating() {
        return this.getX() == -1;
    }

    public void next() {

    }

}