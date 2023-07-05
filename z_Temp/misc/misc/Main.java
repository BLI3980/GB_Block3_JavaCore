package misc;

import java.util.ArrayList;
import java.util.Arrays;
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
        String[][] array = new String[4][];
        array[0] = "1 2".split(" ");
        array[1] = "1 2 3 4 5".split(" ");
        array[2] = "1".split(" ");
        array[3] = "1 2 3".split(" ");

//        array[0][2] = "a"; // Will have index out of bounds exception as the array already filled

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println(Arrays.deepToString(array));

    }


}
