package group01.lecturework.task02;

import java.io.*;
import java.util.List;

/**
 * File handling class.
 * Includes methods:
 *  - READING specified line in the file;
 *  - EDITING specified line in the file;
 *  - INSERTING a line below specified line in the file;
 *  - DELETING specified line in the file;
 *  - APPENDING a line to the end of the file;
 *  - CLEARING the contents of the file;
 *  - SEARCHING a line number of specified string in the file;
 *  - GETTING the amount of lines in the file;
 *  - REPLACING the contents from input file to current file;
 *  - COPYING the contents from input file to the end of current file;
 */
public class MyFileHandler {
    private File fileStorage;
    private String info;

    /**
     * The constructor for the current class.
     * @param filePath - the path to the new file.
     * @param info - information of the new file.
     */
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

    /**
     * Utility method, returns the information commented in the file at the time of creation of the file.
     * @return - the information of the file.
     */
    public String info() {
        return this.info;
    }

    /**
     * Utility method returns a list of lines from input file.
     * @param file - the object of File class.
     * @return - the object of List class containing the list of Strings.
     */
    private List<String> readFile(File file) {
        List<String> fileLines = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            fileLines = bufferedReader.lines().toList();
        } catch (IOException e) {
            System.out.println("IOException: Unable to handle the file.");
        }
        return fileLines;
    }

    /**
     * Method returns a line of the current file by specified line number.
     * @param lineNumber - specified number of the line to be returned.
     * @return - the line of the specified number.
     */
    public String readLine(int lineNumber) {
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

    /**
     * Method replaces a line in the current line.
     * @param lineNumber - the number of the line to be replaced.
     * @param line - the line which replaces specified line in the current file.
     */
    public void edit(int lineNumber, String line) {
        List<String> fileLines = readFile(this.fileStorage);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))) {
            for (int i = 0; i < fileLines.size(); i++) {
                if (i == lineNumber) {
                    writer.append(line).append("\n");
                } else {
                    writer.append(fileLines.get(i)).append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    /**
     * Method inserts a line below specified line of the current file.
     * @param lineNumber - the number of the line below which the input line to be inserted.
     * @param line - the input line to be inserted.
     */
    public void insert(int lineNumber, String line) {
        List<String> fileLines = readFile(this.fileStorage);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))) {
            for (int i = 0; i < fileLines.size(); i++) {
                if (i == lineNumber) {
                    writer.append(line).append("\n");
                    writer.append(fileLines.get(i)).append("\n");
                } else {
                    writer.append(fileLines.get(i)).append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    /**
     * Method deletes a line from the current file.
     * @param lineNumber - the number of the line to be deleted from the file.
     */
    public void delete(int lineNumber) {
        List<String> fileLines = readFile(this.fileStorage);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))){
            for (int i = 0; i < fileLines.size(); i++) {
                if (i != lineNumber) {
                    writer.append(fileLines.get(i)).append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    /**
     * Method appends a line to the end of the current file.
     * @param appendLine - input line to append.
     */
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

    /**
     * Method deletes/clears all the contents of the current file.
     */
    public void clear() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileStorage))) {
            writer.flush();
            writer.flush();
        } catch (IOException e) {
            System.out.println("IOException: Unable to access the file.");
        }
    }

    /**
     * Method searches a line in the current file and returns the number of found line.
     * @param findLine - the input line to be searched in the current file.
     * @return - the number of found line. If searched line does not exist in the current file, method returns -1.
     */
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

//    public int contains(String string) {
//        int foundLineNumber = -1;
//        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileStorage))) {
//            List<String> fileLines = (reader.lines().toList());
//            for (String line : fileLines) {
//                if (line.contains(findLine)) foundLineNumber = fileLines.indexOf(line);
//            }
//        } catch (IOException e) {
//            System.out.println("IOException: Unable to access the file.");
//        }
//        return foundLineNumber;
//    }

    /**
     * Method returns the amount of lines in the current file
     * @return - the amount of lines.
     */
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
