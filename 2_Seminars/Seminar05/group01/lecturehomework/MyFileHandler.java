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
                    writer.append(line + "\n");
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
                    writer.append(fileLines.get(i) + "\n");
                    writer.append(line + "\n");
                } else {
                    writer.append(fileLines.get(i) + "\n");
                }
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    public void delete(int lineNumber, String line) {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileStorage));
             BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))) {
            List<String> fileLines = (reader.lines().toList());
            for (int i = 0; i < fileLines.size(); i++) {
                if (i != lineNumber) {
                    writer.append(fileLines.get(i)).append("\n");
                }
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    public void append(String appendLine) {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileStorage));
             BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))) {
            List<String> fileLines = (reader.lines().toList());
            for (String line : fileLines) {
                writer.append(line).append("\n");
            }
            writer.append(appendLine).append("\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    public void clear() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))) {
            writer.flush();
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    public int find(String findLine) {
        int foundLineNumber = -1;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileStorage))) {
            List<String> fileLines = (reader.lines().toList());
            for (String line : fileLines) {
                if (line.contains(findLine)) foundLineNumber = fileLines.indexOf(line);
            }
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
        return foundLineNumber;
    }

    public int size() {
        int size = -1;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileStorage))) {
            List<String> fileLines = (reader.lines().toList());
            size = fileLines.size();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
        return size;
    }

    /**
     * Method adds to current file information from input file
     * @param input - input file
     */
    public void copy(MyFileHandler input) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input.fileStorage));
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))) {
            List<String> fileLines = (reader.lines().toList());
            this.clear();
            for (String line: fileLines) {
                writer.append(line).append("\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    /**
     * Method reads two files and appends file2 data to file1 data
     * @param file1 - File 1
     * @param file2 - File 2
     */
    public static void copy(MyFileHandler file1, MyFileHandler file2) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file1.fileStorage));
            List<String> file1Lines = (reader.lines().toList());
            reader.close();

            reader = new BufferedReader(new FileReader(file2.fileStorage));
            List<String> file2Lines = (reader.lines().toList());
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file1.fileStorage));
            for (String line: file1Lines) {
                writer.append(line).append("\n");
            }
            for (String line: file2Lines) {
                writer.append(line + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }
    


}
