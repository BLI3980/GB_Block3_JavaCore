package group01.lecturework.task02;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Task: Create program for hashing password and storing it in database.
 * Check correctness of the program by providing username and password and verifying correctness of provided password
 * against stored hash.
 */
public class Main {
    public static void main(String[] args) {
        MyFileHandler database = new MyFileHandler("Database.txt", "file containing logins and passwords.");
        String login = UI.prompt("Enter login: ");
        String password = UI.prompt("Enter password: ");
        String hashPassword = MyHash.hash(password);
        int loginLine = database.find(login);

        if (loginLine == -1) {
            database.append(login + " " + hashPassword);
            System.out.println("User login and password are created in database. ");
        } else {
            String dbPassword = database.readLine(loginLine).split(" ")[1];
            System.out.println(hashPassword);
            System.out.println(dbPassword);
            if (hashPassword.equals(dbPassword)) {
                System.out.println("User authorized.");
            } else {
                System.out.println("Provided password is incorrect");
            }

        }



    }
}
