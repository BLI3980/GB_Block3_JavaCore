package lecture05;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) {
//        System.out.println("================= List all files in current directory =================");
//        File folder = new File(".");
//        for (File file: folder.listFiles()) {
//            System.out.println(file.getName()); // Shows list of all files in the directory
//        }
//
//        System.out.println("================= Other methods of class File =================");
//        System.out.println("Is it a folder - " + folder.isDirectory());         // Is it a folder - true
//        System.out.println("Is it a file - " + folder.isFile());                // Is it a file - false
//        File file = new File("./test1.txt");
//        System.out.println("Length of file - "+ file.length());                 // Length of file - 0
//        System.out.println("Absolute path - "+ file.getAbsolutePath());         // Absolute path - C:\_GB\11_JavaCore\.\test1.txt
//        System.out.println("Total space on disk - "+ file.getTotalSpace());     // Total space on disk - 0
//        System.out.println("File deleted - "+ file.delete());                   // File deleted - true
//        System.out.println("File exists - "+ file.exists());                    // File exists - false
//        System.out.println("Free space on disk - " + folder.getFreeSpace());    // Free space on disk - 196533374976
//
//        System.out.println("================= Path =================");
//        File file1 = new File("test.txt");
//        Path filePath = Paths.get(file1.getName());
//        System.out.println(filePath);                                           // test.txt
//
//        Path filePath1 = Paths.get("Lecture05/lecture05/Main.java");
//
//        Path fileName = filePath1.getFileName();
//        System.out.println("Filename: " + fileName);                            // Filename: Main.java
//        Path parent = filePath1.getParent();
//        System.out.println("Parent directory: " + parent);                      // Parent directory: Lecture05\lecture05
//
//        boolean endWithTxt = filePath1.endsWith("Main.java");
//        System.out.println("Ends with filepath: " + endWithTxt);                // Ends with filepath: true
//        endWithTxt = filePath1.endsWith("java");
//        System.out.println("Ends with string: " + endWithTxt);                  // Ends with string: false
//
//        boolean startsWithPics = filePath1.startsWith("Lecture05/lecture05/");
//        System.out.println("Starts with filepath: " + startsWithPics);          // Starts with filepath: false
//
//        System.out.println(filePath1.isAbsolute());
//        Path pathFirst = Paths.get("./Lecture05/lecture05/Main.java");
//        System.out.println(pathFirst.normalize());
//        Path pathSecond = Paths.get("._GB/../Lecture05/lecture05/Main.java");
//        System.out.println(pathSecond.normalize());
//
//        System.out.println("================= Files =================");
//        try {
//            Path file = Files.createFile(Paths.get("../11_JavaCore/file.txt"));
//            System.out.print("Was the file captured successfully in the projet root directory? ");
//            System.out.println(Files.exists(Paths.get("../11_JavaCore/file.txt")));
//
//            Path testDirectory = Files.createDirectory(Paths.get("./testing"));
//            System.out.print("Was the test directory created successfully? ");
//            System.out.println(Files.exists(Paths.get("./testing")));
//
//            file = Files.move(file, Paths.get("./testing/file.txt"), REPLACE_EXISTING);
//            System.out.print("Is our file still in the project root directory? ");
//            System.out.println(Files.exists(Paths.get("../11_JavaCore/file.txt")));
//            System.out.print("Has our file been moved to test directory? ");
//            System.out.println(Files.exists(Paths.get("./testing/file.txt")));
//
//            Path copyFile = Files.copy(file, Paths.get("../11_JavaCore/file.txt"), REPLACE_EXISTING);
//            System.out.print("Has our file been copied to the project root directory? ");
//            System.out.println(Files.exists(Paths.get("../11_JavaCore/file.txt")));
//
//            Files.delete(file);
//            System.out.print("Does the file exist in test directory? ");
//            System.out.println(Files.exists(Paths.get("./testing/file.txt")));
//            System.out.print("Does the test directory exist? ");
//            System.out.println(Files.exists(Paths.get("./testing")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        System.out.println("================= Files contents =================");
//        List<String> lines= Arrays.asList(
//                "The cat wants to play with you",
//                "But you don't want to play with it"
//        );
//        try {
//            Path file = Files.createFile(Paths.get("./1_Lectures/Lecture05/lecture05/cat.txt"));
//
//            if (Files.exists(file)) {
//                Files.write(file,lines, StandardCharsets.UTF_8);
//                lines = Files.readAllLines(
//                        Paths.get("./1_Lectures/Lecture05/lecture05/cat.txt"),
//                        StandardCharsets.UTF_8
//                );
//            }
//
//            for (String s : lines) {
//                System.out.println(s);
//            }
//
//            Files.delete(file);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("================= FileInputStream and FileOutputStream =================");
//        byte[] bytesToWrite = {0, 10, 12, 14, 55, 13, 23};
//        byte[] bytesToRead = new byte[10];
//        File file = new File("bytes.txt");
//
//        try {
//            System.out.println("Begin");                                                // Begin
//            FileOutputStream outFile = new FileOutputStream(file);
//            outFile.write(bytesToWrite);
//            outFile.close();
//            System.out.println("Bytes written");                                        // Bytes written
//
//            FileInputStream inFile= new FileInputStream(file);
//            int byteAvailable = inFile.available();
//            System.out.println("Ready to read " + byteAvailable + " bytes.");           // Ready to read 7 bytes.
//
//            int count = inFile.read(bytesToRead,0, byteAvailable);
//            for (int i = 0; i < count; i++) {
//                System.out.print(" " + bytesToRead[i]);                                 //  0 10 12 14 55 13 23
//            }
//            System.out.println();
//            inFile.close();
//            System.out.println("Input stream closed");                                  // Input stream closed
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write data to file - " + file.getName());
//        } catch (IOException e) {
//            System.out.println("Error input/output: " + e.toString());
//        }
//
//        System.out.println("================= BufferedFileInputStream and BufferedFileOutputStream =================");
//        String fileName = "testFile.txt";
//        InputStream inStream = null;
//        OutputStream outStream = null;
//        // Write data to file
//        try {
//            long timeStart = System.currentTimeMillis();
//            outStream = new BufferedOutputStream(new FileOutputStream(fileName));
//            for (int i = 1000000; --i>=0;) {
//                outStream.write(i);
//            }
//            long time = System.currentTimeMillis() - timeStart;
//            System.out.println("Writing time: " + time + " millisec.");
//            outStream.close();
//        } catch (IOException e) {
//            System.out.println("IOException: " + e.toString());
//        }
//        // Read data from file without buffer
//        try {
//            long timeStart = System.currentTimeMillis();
//            inStream = new FileInputStream(fileName);
//            while (inStream.read() != -1) {}
//
//            long time = System.currentTimeMillis() - timeStart;
//            inStream.close();
//            System.out.println("Direct read time : " + time + " millisec.");
//        } catch (IOException e) {
//            System.out.println("IOException: " + e.toString());
//            e.printStackTrace();
//        }
//        // Read data from file with butter
//        try {
//            long timeStart = System.currentTimeMillis();
//            inStream = new BufferedInputStream(new FileInputStream(fileName));
//            while (inStream.read() != -1) {}
//
//            long time = System.currentTimeMillis() - timeStart;
//            inStream.close();
//            System.out.println("Buffered read time : " + time + " millisec.");
//        } catch (IOException e) {
//            System.out.println("IOException: " + e.toString());
//            e.printStackTrace();
//        }

        System.out.println("================= String =================");
        String s1 = "Java";
        String s2 = new String("Home");
        String s3 = new String(new char[] {'A', 'B', 'C'});
        String s4 = new String(s3);
        String s5 = new String(new byte[] {65, 66, 67});
        String s6 = new String(new byte[] {0, 65, 0 , 66}, StandardCharsets.UTF_16);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s3.equals(s4));
        System.out.println(s3 == s4);
        System.out.println(s5);
        System.out.println(s6);


        long timeStart = System.nanoTime();
        String str = "Example";
        for (int i = 0; i < 200_000; i++) {
            str = str + i;
        }
        double deltaTime = (System.nanoTime() - timeStart) * 0.000_000_001;
        System.out.println("Delta time (sec): " + deltaTime);

        timeStart = System.nanoTime();
        StringBuilder sb = new StringBuilder("Example");
        for (int i = 0; i < 200_000; i++) {
            sb.append(i);
        }
        deltaTime = (System.nanoTime() - timeStart) * 0.000_000_001;
        System.out.println("Delta time sb (sec): " + deltaTime);

        System.out.println(str.equals(sb.toString()));

    }
}
