package hw02;

public class task01 {
    public static int countEvens(int[] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

}
