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

        MyFileHandler.copy(file1, file2);

    }
}
