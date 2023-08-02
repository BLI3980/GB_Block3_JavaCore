package group02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
//        readTextFile("test.txt", true);

        // ================================================================
        Animal cat = new Cat("Persik", 100);
        Random random = new Random();


        for (int i = 0; i < 10; i++) {
            try {
                int j = random.nextInt(2);
                switch (j) {
                    case 0:
                        cat.swim(i * 10);
                        break;
                    case 1:
                        cat.run(i * 10);
                        System.out.printf("Cat run %d meters.\n", i * 10);
                        break;
                }
            } catch (AnimalSwimException e) {
                System.out.printf("Exception while trying to make %s to swim %d meters.\n%s\n",
                        e.getName(), e.getDistance(), e.getMessage());
            } catch (AnimalRunException e) {
                System.out.printf("Exception while trying to make %s to run %d meters.\n%s\n",
                        e.getName(), e.getDistance(), e.getMessage());
            }
        }
    }

    public static void readTextFile(String fileName, boolean flag) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            char[] buf = new char[256];
            int c;
            while ((c = fileReader.read(buf)) > 0) {
                if (flag) {
                    throw new Exception("Some unexpected exception. ");
                }
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                for (char symbol: buf) {
                    System.out.print(symbol);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("*** Problem while opening the file ***");
        } catch (IOException e) {
            System.out.println("*** Problem while working with the file ***");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {

            }
        }
    }
}
