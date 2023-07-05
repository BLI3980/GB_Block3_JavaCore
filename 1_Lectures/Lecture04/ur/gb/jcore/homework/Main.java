package ur.gb.jcore.homework;

import java.util.Arrays;

/**
 * 1. Write two successor classes of Exception: row mismatch and column mismatch exceptions.
 * 2. Develop these exceptions such way that they would inform user in a format as expectation vs result
 * 3. Write a program calculating the average of all elements of 4x4 array. The program must throw
 * an exception if in the source array there is a mismatch of either the amount of rows or columns, i.e.
 * either not 4 rows or not 4 columns.
 */
public class Main {

    public static void main(String[] args) {
        try {
//            final String[][] matrix = stringToMatrix(CORRECT_STRING);
//            final String[][] matrix = stringToMatrix(NO_ROW_STRING);
//            final String[][] matrix = stringToMatrix(NO_COL_STRING);
            final String[][] matrix = stringToMatrix(HAS_CHAR_STRING);
            System.out.println(Arrays.deepToString(matrix));
            System.out.println("The average of all elements of the array = " + calcMatrix(matrix));
        } catch (NumberIsNotNumberException e) {
            System.out.println("A NumberFormatException is thrown: " + e.getMessage());
        } catch (RowMismatchException | ColumnMismatchException e) {
            System.out.println("A RuntimeException successor is thrown: " + e.getMessage());
        }
    }
    private static final class ColumnMismatchException extends RuntimeException {
        public ColumnMismatchException(String message) {
            super("Column exception: " + message);
        }
    }

    private static final class NumberIsNotNumberException extends RuntimeException {
        public NumberIsNotNumberException(String message) {
            super("Not a number found: " + message);
        }
    }

    private static final class RowMismatchException extends RuntimeException {
        public RowMismatchException(int expected, int current, String value) {
            super(String.format("Rows exception: expected %d rows. Received %d rows " +
                                "in\n%s\nstring.", expected, current, value));
        }
    }

    private static final String CORRECT_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    private static final String EXTRA_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0\n1 2 3 4 ";
    private static final String EXTRA_COL_STRING = "1 3 1 2 1\n2 3 2 2 1\n5 6 7 1 1\n3 3 1 0 1";
    private static final String NO_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1";
    private static final String NO_COL_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1";
    private static final String HAS_CHAR_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 A";

    private static final int MAXTRIX_ROWS = 4;
    private static final int MAXTRIX_COLS = 4;

    private static String[][] stringToMatrix(String value) {
        String[] rows = value.split("\n");
        if (rows.length != MAXTRIX_ROWS) {
            throw new RowMismatchException(MAXTRIX_ROWS, rows.length, value);
        }

        String[][] result = new String[MAXTRIX_ROWS][];
        for (int i = 0; i < rows.length; i++) {
            result[i] = rows[i].split(" ");
            if (result[i].length != MAXTRIX_COLS) {
                throw new ColumnMismatchException(result[i].length + ":\n" + value);
            }
        }
        return result;
    }

    private static float calcMatrix(String[][] matrix) {
        float result = 0;
        int len = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    result += Integer.parseInt(matrix[i][j]);
                    ++len;
                } catch (NumberFormatException e) {
                    throw new NumberIsNotNumberException("Symbol \"" + matrix[i][j] +
                            "\" at position [" + i + "][" + j + "" +"]");
                }
            }
        }
        return result / len;
    }
}
