package snake;

public class Controller {
    GameSnake game;
    Snake snake;

    public Controller(GameSnake game) {
        this.game = game;
    }

//    public void run() {
//        snake = new Snake(
//                START_SNAKE_X,
//                START_SNAKE_Y,
//                START_SNAKE_SIZE,
//                KEY_RIGHT);
//
//        food = new Food(snake);
//        snake.setFood(food);
//
//        while(!gameOver) {
//            snake.move();
//            if (snake.size() > snakeSize) {
//                snakeSize = snake.size();
//                setTitle(TITLE_OF_PROGRAM + ": " + snakeSize);
//            }
//
//            if (food.isEaten()) {
//                food.appear();
//            }
//
//            canvas.repaint();
//            sleep(SNAKE_DELAY);
//        }
//    }
}
