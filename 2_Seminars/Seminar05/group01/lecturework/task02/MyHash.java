package group01.lecturework.task02;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MyHash {
    /**
     * Method in Java for converting password to hash.
      */

    public static String hash(String password) {
        MessageDigest md = null; // Declare object which will convert password to hash
        try {
            md = MessageDigest.getInstance("MD5"); // Create new instance of the object by MD5 algorithm
//            md = MessageDigest.getInstance("SHA-256"); // Create new instance of the object by SHA256 algorithm
        } catch (
                NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(password.getBytes()); // The object converts password to hash
        byte[] digest = md.digest(); // Create an array of bytes from created hash

        BigInteger bigInt = new BigInteger(1,digest);
        String md5Hex = bigInt.toString(16);
        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex; // Increasing the string up to 32 bit length for MD5 hash.
        }
        return md5Hex;
    }

}
