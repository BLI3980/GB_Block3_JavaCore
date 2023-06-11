package ru.gb.jcore.regular;

/**
 * Other, very handy class of the application. Here we can describe
 * its main purpose and methods of interaction with it.
 */

public class OtherClass {
    /**
     * Method for summation of two numbers
     *
     * @param a - the first term
     * @param b - the second term
     * @return - the sum of a and b, without a check for variable overflow
     */
    public static int add(int a, int b) {
        return a + b; // return without a check for overflow
    }

    /**
     * Method for subtraction of two numbers
     *
     * @param a - the minuend
     * @param b - the subtrahend
     * @return - the difference of a and b, without a check for variable overflow
     */
    public static int sub(int a, int b) {
        return a - b; // return without a check for overflow
    }

    /**
     * Method for multiplication of two numbers
     *
     * @param a - the first multiplier
     * @param b - the second multiplier
     * @return - the product of a and b, without a check for variable overflow
     */
    public static int mul(int a, int b) {
        return a * b; // return without a check for overflow
    }

    /**
     * Method for division of two numbers
     *
     * @param a - the dividend
     * @param b - the divider
     * @return - the quotient of a and b, without a check for variable overflow
     */
    public static int div(int a, int b) {
        return b == 0 ? a : a / b; // return without a check for overflow
    }
}
