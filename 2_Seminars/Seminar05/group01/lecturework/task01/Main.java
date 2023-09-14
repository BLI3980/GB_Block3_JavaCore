package group01.lecturework.task01;

public class Main {
    public static void main(String[] args) {
        MyFileHandler file1 = new MyFileHandler("inputFile", "input file.");
        MyFileHandler file2 = new MyFileHandler("encrypted", "encrypted file.");
        MyFileHandler file3 = new MyFileHandler("decrypted", "decrypted file.");

        for (int i = 0; i < file1.size(); i++) {
            String tempEncrypt = file1.readLine(i);
            System.out.println("Original text: " + tempEncrypt);
            tempEncrypt = Cypher.encrypt(tempEncrypt, 2);
            System.out.println("Encrypted text: " + tempEncrypt);
            file2.append(tempEncrypt);

            String tempDecrypt = file2.readLine(i);
            tempDecrypt = Cypher.decrypt(tempDecrypt, 2);
            System.out.println("Decrypted text: " + tempDecrypt);
            file3.append(tempDecrypt);


        }

    }
}
