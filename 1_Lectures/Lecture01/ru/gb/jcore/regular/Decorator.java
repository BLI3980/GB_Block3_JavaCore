package ru.gb.jcore.regular;

/**
 * Decorator. It decorates, i.e. add some decoration on the result.
 * The appearance of the result is important, that's why this class is created.
 */
public class Decorator {
    /**
     * Method of decorating of a number for the output into a console is such a
     * format that the number is preceded by a phrase "Here is your number: ".
     *
     * @param a - a number needing the decoration
     * @return - The decorated result in the form of a string.
     */
    public static String decorate(int a) {
        /**
         * Method decorates a number by adding a phrase before it
         * with help of built-in string formatting method.
         */
        return String.format("Here is your number: %d.", a);
    }
}
