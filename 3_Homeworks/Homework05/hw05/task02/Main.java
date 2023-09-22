package hw05.task02;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        int[][] theField = fillTheField();
//        System.out.println(Arrays.deepToString(theField));
//        String fieldNumber = ticTacToeField(theField);
//        System.out.println(fieldNumber);
        // Array of n x 3 tic-tac-toe field elements of random values:
        int[] field = fillTheField1(3);
        System.out.println(Arrays.toString(field));
        System.out.println(ticTacToeField(field));
        String fieldString = ticTacToeField(field);
        out(fieldString);
        System.out.println(Arrays.toString(input("./3_Homeworks/Homework05/hw05/task02/file.txt")));




    }

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
//            System.out.println(row);
            array = array + row + "\n";
            row = "";
        }
        return array;
    }

    public static int[][] fillTheField() {
        int[][] result = new int[3][3];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = new Random().nextInt(4);
            }
        }
        return result;
    }

    public static String ticTacToeField(int[] field) {
        int rowSize = field.length/3;
        byte tempByte;
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

    public static void out(String input) {
        File file = new File("./3_Homeworks/Homework05/hw05/task02/file.txt");
        String[] splitInput = input.split(" ");
        int temp = 1;
        try(FileOutputStream out = new FileOutputStream(file)) {
            for (String item: splitInput) {
                System.out.println(item);
                System.out.println(Integer.parseInt(item));
                out.write((byte)Integer.parseInt(item));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] input(String filePath) {
        File file = new File(filePath);
        byte[] value;
        try(FileInputStream in = new FileInputStream(file)) {
            value = in.readAllBytes();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    public static int[] fillTheField1(int rowSize) {
        int[] result = new int[rowSize*3];
        for (int i = 0, j = rowSize, k = rowSize*2; i < rowSize; i++, j++, k++) {
            result[i] = new Random().nextInt(4);
            result[j] = new Random().nextInt(4);
            result[k] = new Random().nextInt(4);
        }
        return result;
    }
}
