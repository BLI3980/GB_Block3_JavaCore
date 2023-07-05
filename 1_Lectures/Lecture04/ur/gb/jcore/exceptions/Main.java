package ur.gb.jcore.exceptions;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        methodA();
//        methodB();
        // Up to JDK 7 inclusive:
        // =========================================
//        TestStream stream = null;
//        try {
//            stream = new TestStream();
//            int i = stream.read();
////            stream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                stream.close();
//            } catch (IOException e) {
////                e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }
        // =========================================
        // From JDK 8:
        // =========================================
        try (TestStream stream = new TestStream()) {
            int i = stream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // =========================================

    }

    public static void methodA() {
        RuntimeException e = new RuntimeException("A message. ");
        throw e;
    }

    public static void methodB() {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new RuntimeException(e);          // java.io.IOException
//            System.out.println(e.getMessage());   // null
        }
    }

    public static class TestStream implements Closeable {
        public TestStream() throws IOException{
            System.out.println("construct OK");
//            throw new IOException();
        }

        public int read() throws FileNotFoundException {
            new FileInputStream("file.txt");
            System.out.println("read OK");
            return 1;
        }

        public void close()  throws IOException {
            System.out.println("close OK");
            throw new IOException();
        }
    }
}
