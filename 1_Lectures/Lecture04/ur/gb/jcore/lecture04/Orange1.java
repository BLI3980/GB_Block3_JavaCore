package ur.gb.jcore.lecture04;

/**
 * Nested classes. Non-static inner class.
 * Such connection of classes and instances is called Composition.
 */
public class Orange {
    private Juice juice;
    public Orange() {
        this.juice = new Juice();
    }

    public void squeezeJuice() {
        System.out.println("Squeeze juice... ");
        juice.flow();
    }

    private class Juice {

        public void flow()  {
            System.out.println("Juice dripped... ");
        }
    }

}
