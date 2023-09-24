package misc;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        int a = 10.3f/3.0f;

        // ============================================================
//        String test = "test";
//        char c = test.charAt(2);
//        System.out.println(c);
//        int c1 = c;
//        char i = (char) (c + 2);
//        System.out.println(c1);
//        System.out.println(i);

        // ============================================================
//        enum Seasons {WINTER, SPRING, SUMMER, AUTUMN};
//        System.out.println(Arrays.toString(Seasons.values()));
        // ============================================================

        // When initializing an array, we can define only the first dimension!
//        String[][] array = new String[4][];
//        array[0] = "1 2".split(" ");
//        array[1] = "1 2 3 4 5".split(" ");
//        array[2] = "1".split(" ");
//        array[3] = "1 2 3".split(" ");
//
////        array[0][2] = "a"; // Will have index out of bounds exception as the array already filled
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(Arrays.toString(array[i]));
//        }
//        System.out.println(Arrays.deepToString(array));
        // ============================================================
//        String bin = Integer.toBinaryString(3);
//        System.out.println(bin);

        // ============================================================
//        try {
//            FileOutputStream outputStream = new FileOutputStream("stringData.txt");
//            String data = "Some random test to write to the file.";
//            outputStream.write(data.getBytes());
//            outputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // ============================================================
//        try {
//            FileOutputStream out = new FileOutputStream("temp.txt");
//            byte one = 64;
//            byte two = 33;
//            byte three = 0;
//            System.out.println(one);
//            System.out.println(two);
//            System.out.println(three);
//            System.out.println((byte)one);
//            System.out.println((byte)two);
//            System.out.println((byte)three);
////            out.write((byte)one);
////            out.write((byte)two);
////            out.write((byte)three);
//            out.write(one);
//            out.write(two);
//            out.write(three);
//            out.close();
//            FileInputStream in = new FileInputStream("temp.txt");
////            System.out.println(Arrays.toString(in.readAllBytes()));
//            byte[] bytes = in.readAllBytes();
////            System.out.println(bytes.length);
////            System.out.println(bytes[0]);
//            for (byte item: bytes) {
//                System.out.println((int)item);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // ============================================================
//        HashMap<Byte,String> map = new HashMap<>();
//        byte key = 1;
//        String value = "";
//        for (int i = 0; i < 334; i++) {
//            if (String.valueOf(i).matches("^[0-3_]+$")) {
//                if(i < 10) {
//                    value = "00" + i;
//                } else if (i < 100) {
//                    value = "0" + i;
//                } else {
//                    value = String.valueOf(i);
//                }
//                map.put(key,value);
//                System.out.println(key + ": " + value);
//                key++;
//            }
//        }
        // ============================================================
        int[] array = new int[] {3, 3, 3};
        String str = "";
        for (int item : array) {
            str += Integer.toBinaryString(item);
        }
        System.out.println(str);
        int binToDec = Integer.parseInt(str, 2);
        System.out.println(binToDec);
        byte b = (byte)binToDec;
        System.out.println(b);
//        byte b = Byte.parseByte(str);
//        System.out.println(str);

    }


}
