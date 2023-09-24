package hw05.task02;

import java.io.*;
import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Created 3 x 3 field
        int[][] theField = fillTheField();
        // Printout the field
        System.out.println(Arrays.deepToString(theField));
        // The field converted to String of binary rows
        String binString = ticTacToeField(theField);
        // Print the String
        System.out.println(binString);
        // Create byte array, each byte is row of elements of tic-tac-toe field
        byte[] b = byteField(binString);
        // Print the byte array
        System.out.println(Arrays.toString(b));
        // Output the array to file
        output(b);
        // Get the array back from file. Print it to console
        System.out.println(Arrays.toString(input("./3_Homeworks/Homework05/hw05/task02/file.txt")));

    }



    // =================== Option 1 ======================================================================

    /**
     * Method for creating 3 x 3 array of numbers representing randomly filled tic-tac-toe field
     * @return
     */
    public static int[][] fillTheField() {
        int[][] result = new int[3][3];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = new Random().nextInt(4);
            }
        }
        return result;
    }

    /**
     * Method converts bi-dimensional integer array to String lines.
     * Each line representing one element of the outer array (i.e. one inner array).
     * The numbers of inner array are first converted from decimal to binary radix, and then concatenated
     * into a String line.
     * @param field
     * @return
     */
    public static String ticTacToeField(int[][] field) {
        String array = "";
        String row = "";
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] < 2) {
                    row = row + "0" + Integer.toBinaryString(field[i][j]);
                } else {
                    row = row + Integer.toBinaryString(field[i][j]);
                }
            }
            array = array + row + "\n";
            row = "";
        }
        return array;
    }

    /**
     * Method converts the field from String format to byte format.
     * Each byte represents the row of elements of tic-tac-toe field.
     * @param binString
     * @return
     */
    public static byte[] byteField(String binString) {
        String[] lines = binString.split("\n");
        byte[] result = new byte[lines.length];
        System.out.println(Arrays.toString(lines));
        for (int i = 0; i < lines.length; i++) {
            result[i] = (byte)Integer.parseInt(lines[i], 2);
        }
        return result;
    }

    // =================== Option 2 (to be discarded) =========================================================
    /**
     * Method for creating array of numbers representing randomly filled tic-tac-toe field.
     * The amount of rows is always 3.
     * @param rowSize - the size of rows of the field
     * @return
     */
    public static int[] fillTheField1(int rowSize) {
        int[] result = new int[rowSize*3];
        for (int i = 0, j = rowSize, k = rowSize*2; i < rowSize; i++, j++, k++) {
            result[i] = new Random().nextInt(4);
            result[j] = new Random().nextInt(4);
            result[k] = new Random().nextInt(4);
        }
        return result;
    }

    /**
     * Method converts one-dimensional integer array to String.
     * An array represents a tic-tac-toe field of three rows. The size of each row is 1/3 of the array.
     * The numbers of each row are first converted from decimal to binary radix, and then concatenated
     * into a String line.
     * @param field
     * @return
     */
    public static String ticTacToeField(int[] field) {
        int rowSize = field.length/3;
        String temp = "00";
        String result = "";
        for (int row = 0; row < 3; row++) {
            for (int element = row * rowSize; element < (row * rowSize + rowSize); element++) {
                if (field[element] < 2) {
                    temp = temp + "0" + Integer.toBinaryString(field[element]);
                } else {
                    temp = temp + Integer.toBinaryString(field[element]);
                }
            }

            result += temp + " ";
            temp = "00";

        }
        return result;
    }

    // =================== Input/output ======================================================================
    public static void output(byte[] byteArray) {
        File file = new File("./3_Homeworks/Homework05/hw05/task02/file.txt");
        try(FileOutputStream out = new FileOutputStream(file)) {
            for (byte item: byteArray) {
                out.write(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] input(String filePath) {
        File file = new File(filePath);
        byte[] value;
        try(FileInputStream in = new FileInputStream(file)) {
            value = in.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;
    }


}
