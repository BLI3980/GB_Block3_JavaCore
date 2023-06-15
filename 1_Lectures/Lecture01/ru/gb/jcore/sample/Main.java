package ru.gb.jcore.sample;

import ru.gb.jcore.regular.Decorator;
import ru.gb.jcore.regular.OtherClass;

/**
 * main.misc.Main class of the application. Here we can describe
 * its main purpose and methods of interaction with it.
 */

public class Main {
    /** The entry point into the application. Everything always starts
     * from it.
     *
     * @param args - standard arguments of the command line
     */
    public static void main(String[] args) {
        int result = OtherClass.add(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.sub(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.mul(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.div(2, 2);
        System.out.println(Decorator.decorate(result));
    }
}