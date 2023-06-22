package group01.main;

import group01.caesar.Caesar;

public class Main {
    public static void main(String[] args) {
        String test = Caesar.caesar("test", 2, false);
        System.out.println(test);
    }
}
