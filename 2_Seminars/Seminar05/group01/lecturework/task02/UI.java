package group01.lecturework.task02;

import java.util.Scanner;

public class UI {
    public static String prompt(String msg) {
        Scanner input = new Scanner(System.in);
        System.out.print(msg);
        return input.nextLine();
    }
}
