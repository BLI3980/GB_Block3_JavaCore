package ru.gb.jcore.innerClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        // ENUM ============================================
        System.out.println(Color.GREEN.getCode());  // #00FF00
        System.out.println(Color.RED.getCode());    // #FF0000

        for (Color c: Color.values()) {
            System.out.printf("%s(%s) ", c, c.getCode()); // RED(#FF0000) BLUE(#0000FF) GREEN(#00FF00)
        }

        System.out.println("\n=========================================");
        // Nested Classes ============================================
        System.out.println("==== Oracle example ====");
        Orange orange = new Orange();               // Initialize Outer Class instance
        Orange.Juice juice = orange.new Juice();    // Initialize Inner Class instance
        orange.squeezeJuice();                      // Outer class method
        juice.flow();                               // Inner class method

        System.out.println("==== Lecturer example ====");
        Orange1 orange1 = new Orange1();            // Initialize Outer Class instance.
        // Automatically initializes Inner Class instance in Outer Class constructor
        orange1.squeezeJuice();                     // Outer Class method. Contains Inner Class method inside


    }
    enum Color {
        RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");

        private String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }


    }

//    private static class Orange {                 // Has to be static if inside Main...
//        private Juice juice;
//        public Orange() {
//            this.juice = new Juice();
//        }
//
//        public void squeezeJuice() {
//            System.out.println("Squeeze juice... ");
//            juice.flow();
//        }
//
//        private class Juice {
//
//            public void flow()  {
//                System.out.println("Juice dripped... ");
//            }
//        }
//
//    }


}
