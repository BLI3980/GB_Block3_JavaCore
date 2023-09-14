package group01.lecturework.task02;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MyHash {
    /**
     * Method in Java for converting password to hash.
      */

    public static String hash(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (
                NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String temp = "";
        for (byte b : digest) {
            temp = temp + (char)(b);
        }

        return temp;
//        String myHash = DataTypeConverter.printHexBinary(digest).toUpperCase();
    }

}
