package group01.caesar;

public class Caesar {
    public static String caesar(String in, int key, boolean encrypt) {
        if (in == null || in.isEmpty())
            return null;

        final int len = in.length();
        char[] out = new char[len];
        for (int i = 0; i < len; i++) {
            out[i] = (char) (in.charAt(i) + (encrypt ? key : -key));
        }
        return new String(out);
    }
}
