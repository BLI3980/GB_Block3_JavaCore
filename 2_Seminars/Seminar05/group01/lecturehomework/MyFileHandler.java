package group01.lecturehomework;

import java.io.*;
import java.util.List;

public class MyFileHandler {
    private File fileStorage;
    private String info;
    public MyFileHandler(String filePath, String info) {
        this.fileStorage = new File(filePath);
        try {
            if (!this.fileStorage.exists()) {
                this.fileStorage.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("IOException: Unable to create new file.");
        }
        this.info = info;
    }

    public String info() {
        return this.info;
    }

    public String read(int lineNumber) {
        String line = null;
        try (BufferedReader fileStream = new BufferedReader(new FileReader(this.fileStorage))) {

            List<String> fileLines = (fileStream.lines().toList());
            if (lineNumber < fileLines.size() && lineNumber >= 0) {
                line = fileLines.get(lineNumber);
            }
        } catch (IOException e) {
            System.out.println("IOException: Unable to read the file.");
        }
        return line;
    }
    
    public void edit(int lineNumber, String line) {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileStorage));
             BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))) {
            List<String> fileLines = (reader.lines().toList());
            for (int i = 0; i < fileLines.size(); i++) {
                if (i == lineNumber) {
                    writer.append(line);
                } else {
                    writer.append(fileLines.get(i));
                }
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    public void insert(int lineNumber, String line) {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileStorage));
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))) {
            List<String> fileLines = (reader.lines().toList());
            for (int i = 0; i < fileLines.size(); i++) {
                if (i == lineNumber) {
                    writer.append(fileLines.get(i));
                    writer.append(line);
                } else {
                    writer.append(fileLines.get(i));
                }
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }
    


}
