package hw05.task01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) {
        // Create new test directory
        File folder = new File("C:\\_GB\\11_JavaCore\\3_Homeworks\\Homework05\\hw05\\task01\\FolderToBackup");
        System.out.println(folder.mkdir());

        // Create several test files inside the test directory
        String folderPath = ".\\3_Homeworks\\Homework05\\hw05\\task01\\FolderToBackup\\";
        for (int i = 0; i < 6; i++) {
            File file = new File(folderPath + "File"+ i + ".txt");
            try (FileWriter fileWriter = new FileWriter(file)){
                fileWriter.append("test line for test file " + i + ".");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
//        System.out.println(folder.toPath().toString());
        backup(folder.toPath());



    }

    public static void backup(Path directory) {
        Path backupDirectory = Paths.get("./3_Homeworks/Homework05/hw05/task01/Backup");
        try {
            for (Path file : directory) {
                if (!Files.isDirectory(file)) {
                    Files.copy(file, backupDirectory, REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
