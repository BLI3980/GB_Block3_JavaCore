package group01.lecturehomework;

public class Main {
    public static void main(String[] args) {
        // Create two files
        MyFileHandler file1 = new MyFileHandler("File1", "First file");
        MyFileHandler file2 = new MyFileHandler("File2", "Second file");
        file1.clear();
        file2.clear();

        // Fill file1
        StringBuilder dataToWrite = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            dataToWrite.append("File 1 String number: " + i + "\n");
        }
        file1.append(dataToWrite.toString());

        // Fill file2
        dataToWrite = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            dataToWrite.append("File 2 String number: " + i + "\n");
        }
        file2.append(dataToWrite.toString());

        // Concatenate two files. Data from file 2 added at the end of file 1 data.
        MyFileHandler.copy(file1, file2);

        // Delete line 3 from file 1. Line 4 becomes the third line.
        file1.delete(3); // delete line 3 from file1
        System.out.println(file1.readLine(3)); // File 1 String number: 4

        // Edit line 3 from file 1.
        file1.edit(3, "Edited line 3.");
        System.out.println(file1.readLine(3)); // Edited line 3.

        file1.insert(2, "Inserted line 2.");
        System.out.println(file1.readLine(2)); // Edited line 3.




    }
}
