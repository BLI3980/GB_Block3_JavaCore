package snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameSnake extends JFrame {
    final String TITLE_OF_PROGRAM = "Classic Game Snake";
    final String GAME_OVER_MSG = "GAME OVER";
    final static int CELL_SIZE = 20;            // size of cell in pix
    final static int CANVAS_WIDTH = 30;         // width in cells
    final static int CANVAS_HEIGHT = 25;        // height in cells
    final static Color SNAKE_COLOR = Color.darkGray;
    final static Color FOOD_COLOR = Color.green;
    final static Color POISON_COLOR = Color.red;
    final static int KEY_LEFT = 37;             // codes
    final static int KEY_UP = 38;               //    of
    final static int KEY_RIGHT = 39;            //    cursor
    final static int KEY_DOWN = 40;             //    keys

    Canvas canvas;          // canvas object for rendering (drawing)
    Snake snake;            // declare a snake object
    Food food;              // declare a food object
    Poison poison;          // declare d poison object


    public static void main(String[] args) {
        GameSnake.run();
    }

    private static void run() {

    }

    public GameSnake() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new Canvas();
        canvas.setBackground(Color.WHITE);
        canvas.setPreferredSize(new Dimension(CELL_SIZE * CANVAS_WIDTH,
                                                CELL_SIZE * CANVAS_HEIGHT));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                snake.setDirection(e.getKeyCode());
            }
        });
        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
