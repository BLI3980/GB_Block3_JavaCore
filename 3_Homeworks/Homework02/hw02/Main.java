package hw02;

public class Main {
    public static void main(String[] args) {
        /*
        * Task 01. Write a method counting the amount of elements of even values in an array.
        */
        int[] array1 = {1, 4, 17, 258, -3, 0};
        int[] array2 = {3, 7};
        int[] array3 = {2, 4, 6, 8};
        System.out.println("The amount of even numbers in the array is: " + task01.countEvens(array1));
        System.out.println("The amount  of even numbers in the array is: " + task01.countEvens(array2));
        System.out.println("The amount  of even numbers in the array is: " + task01.countEvens(array3));

        /*
        * Task 02. Write a method calculating the difference between min and max values of the elements of an array.
        */
        System.out.println("The difference between min and max values of the array elements is: " +
                            task02.minMaxDifference(array1));
        System.out.println("The difference between min and max values of the array elements is: " +
                            task02.minMaxDifference(array2));
        System.out.println("The difference between min and max values of the array elements is: " +
                            task02.minMaxDifference(array3));

        /*
        * Task 03. Write a method returning true, if two adjacent elements of zero value in an array.
        */
        System.out.println("The array has two adjacent elements of zero value: " + task03.twoAdjacentZeros(array1));
        System.out.println("The array has two adjacent elements of zero value: " +
                task03.twoAdjacentZeros(new int[]{1, 2, 0, 0}));

    }
}
