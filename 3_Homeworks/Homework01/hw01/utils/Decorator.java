package hw01.utils;

/**
 * Decorator. It decorates, i.e. add some decoration on the result.
 * The appearance of the result is important, that's why this class is created.
 */
public class Decorator {
    /**
     * Method that decorates the result of conversion by adding an explanation text to
     * the result. For example, "In 1 mi there are 5280 ft.".
     *
     * @param input - the result of a conversion needing the decoration
     * @return - The decorated result in the form of a string.
     */
    public static String decorate(String[] input) {
        /**
         * Method decorates the result of conversion by adding an explanation text to
         * the result with help of built-in string formatting method.
         */
        return String.format("In %s %s there are %s %s.", input[0], input[2], input[1], input[3]);
    }
}
