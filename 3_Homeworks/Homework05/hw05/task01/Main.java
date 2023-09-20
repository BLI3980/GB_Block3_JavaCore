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
        System.out.println("Folder just created? " + folder.mkdir());

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

        // Backup files from the test directory to the backup directory
        backup(folder.toPath());



    }

    public static void backup(Path directoryPath) {
        // Create backup directory path
        Path backupPath = Paths.get("./3_Homeworks/Homework05/hw05/task01/Backup");
        System.out.println("Source directory exists? " + Files.exists(directoryPath));
        try {
            // Create backup directory
            if (!Files.exists(backupPath)) {
                Path backupDirectory = Files.createDirectory(backupPath);
                System.out.println("Backup directory created? " + Files.exists(backupDirectory));
            }

            // Copy files from directory into backup directory
            for (Path sourceFile : Files.list(directoryPath).toList()) {
                if (!Files.isDirectory(sourceFile)) {
                    Path backupFile = Path.of(backupPath + "/" + sourceFile.getFileName());
                    Files.copy(sourceFile, backupFile, REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
