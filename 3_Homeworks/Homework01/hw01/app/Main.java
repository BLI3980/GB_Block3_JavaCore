package hw01.app;

import hw01.utils.Converter;
import hw01.utils.Decorator;

/**
 * Main class of the application. Here we can describe
 * its main purpose and methods of interaction with it.
 */
public class Main {
    /** The entry point into the application. Everything always starts
     * from it.
     *
     * @param args - standard arguments of the command line
     */
    public static void main(String[] args) {
        String[] mileToFt = Converter.convert(1, "mi", "ft");
        System.out.println(Decorator.decorate(mileToFt));
        String[]inToMeter = Converter.convert(2, "in", "m");
        System.out.println(Decorator.decorate(inToMeter));
        String[]ftToMm = Converter.convert(8, "ft", "mm");
        System.out.println(Decorator.decorate(ftToMm));
    }
}
