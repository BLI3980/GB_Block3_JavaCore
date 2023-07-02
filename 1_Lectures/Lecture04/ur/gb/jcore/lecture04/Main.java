package ur.gb.jcore.lecture04;

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
        Orange orange = new Orange();
        Orange.Juice juice = orange.new Juice();
        orange.squeezeJuice();
        juice.flow();
        System.out.println("==== Lecturer example ====");
        Orange1 orange1 = new Orange1();
        orange1.squeezeJuice();


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

//    private static class Orange {
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
