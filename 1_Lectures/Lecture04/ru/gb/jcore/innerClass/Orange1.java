package ru.gb.jcore.innerClass;

/**
 * Nested classes. Non-static inner class.
 * Such connection of classes and instances is called Composition.
 */
public class Orange1 {
    private Juice juice;
    public Orange1() {
        this.juice = new Juice();
    }

    public void squeezeJuice() {
        System.out.println("Squeeze juice... ");
        juice.flow();
    }

    // Inner Class
    private class Juice {

        public void flow()  {
            System.out.println("Juice dripped... ");
        }
    }

}
