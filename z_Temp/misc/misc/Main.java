package misc;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int a = 10.3f/3.0f;

        String test = "test";
        char c = test.charAt(2);
        System.out.println(c);
        int c1 = c;
        char i = (char) (c + 2);
        System.out.println(c1);
        System.out.println(i);


        enum Seasons {WINTER, SPRING, SUMMER, AUTUMN};

        System.out.println(Arrays.toString(Seasons.values()));
    }
}
