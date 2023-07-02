package ur.gb.jcore.lecture04;

/**
 * Nested classes. Non-static inner class. Oracle example.
 */
public class Orange {
    public void squeezeJuice() {
        System.out.println("Squeeze juice... ");
    }

    // Inner Class
    class Juice {
        public void flow() {
            System.out.println("Juice dripped... ");
        }
    }
}
