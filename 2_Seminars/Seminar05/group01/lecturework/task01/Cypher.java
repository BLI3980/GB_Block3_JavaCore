package group01.lecturework.task01;

import java.util.Arrays;

public class Cypher {
    private int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public static String encrypt(String openText, int key) {
        openText = openText.toLowerCase();
        char[] temp = openText.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (char) (Character.codePointAt(temp, i) + key);
//            temp[i] = (char)((int)temp[i] + key);
        }
        return new String(temp);
    }

    public static String decrypt(String encrypted, int key) {
        encrypted = encrypted.toLowerCase();
        char[] temp = encrypted.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (char) (Character.codePointAt(temp, i) - key);
//            temp[i] = (char)((int)temp[i] + key);
        }
        return new String(temp);

    }
}
