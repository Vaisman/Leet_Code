package medium;

import java.util.LinkedList;

public class Solution353 {
    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] food;
    int height;
    int width;
    LinkedList<Point> snake;
    Point head;
    int score;

    public Solution353(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new LinkedList<>();
        head = new Point(0, 0);
        score = 0;
        snake.addFirst(new Point(0, 0));
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        if (direction.equals("U"))
            head.row--;
        else if (direction.equals("D"))
            head.row++;
        else if (direction.equals("L"))
            head.col--;
        else
            head.col++;

        if (head.row < 0 || head.row >= height || head.col < 0 || head.col >= width)
            return -1;

        if (score < food.length && food[score][0] == head.row && food[score][1] == head.col)
            score++;
        else
            snake.removeLast();

        if (biteSelf()) {
            return -1;
        }

        snake.addFirst(new Point(head.row, head.col));

        return score;
    }

    private boolean biteSelf() {
        for (Point p : snake) {
            if (p.row == head.row && p.col == head.col)
                return true;
        }
        return false;
    }
}
