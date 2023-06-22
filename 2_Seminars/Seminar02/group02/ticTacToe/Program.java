package group02.ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static char[][] field;  // Bi-dimensional array containing current condition of game field
    private static final Random random = new Random();
    private static int fieldSizeX;  // Game field dimension X
    private static int fieldSizeY;  // Game field dimension Y


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI))
                    break;
            }
            System.out.println("Do you want to play again? (Y/N)");
            String response = SCANNER.next();
            if (!response.equalsIgnoreCase("Y"))
                break;
        }


    }

    /**
     * Initialization of game field
     */
    private static void initialize() {
        // Set dimension of game field
        fieldSizeX = 3;
        fieldSizeY = 3;

        field = new char[fieldSizeX][fieldSizeY];
        // Traverse all elements of the array
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                // Initialize all elements of the array with DOT_EMPTY (empty field)
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Render game field
     */
    private static void printField() {
        // Header
        System.out.print("+");
        for (int i = 0; i < fieldSizeX *2 + 1; i++) {
            System.out.print((i % 2 ==0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        // Body
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[j][i] + "|");
            }

            System.out.println();
        }

        // Footer
        for (int i = 0; i < fieldSizeX *2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Human turn
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.printf("Enter X and Y coordinates of your move" +
                                "(from %d to %d), separated by space >>",
                                fieldSizeY, fieldSizeY);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while(!isCellValid(x, y) || !isCellEmpty(x, y)); // Repeat loop while condition is true.
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Check if cell is empty
     * @param x - X coordinate
     * @param y - Y coordinate
     * @return - the result of the check
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Check the correctness of entry values
     * (coordinates of move must not exceed game field dimensions)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * AI turn
     */
    private static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while(!isCellEmpty(x, y)); // Repeat loop while condition is true.
        field[x][y] = DOT_AI;
    }

    /**
     * Check for victory
     * @param c
     * @return
     */
    private static boolean checkWin(char c) {
        // Check for any of horizontals
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
        // Check for any of verticals
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
        // Check for any of diagonals
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    /**
     * Check for draw
     * @return
     */
    private static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * Check if game is finished
     * @param c
     * @return
     */
    private static boolean gameCheck(char c) {
        if (checkWin(c)) {
            if (c == 'X') System.out.println("Human has won!");
            if (c == 'O') System.out.println("AI has won!");
            return true;
        }
        if (checkDraw()) {
            System.out.println("The draw.");
            return true;
        }
        return false; // The game continues.
    }


}
