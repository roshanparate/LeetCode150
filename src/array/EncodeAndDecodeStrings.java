package array;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");
        strs.add("This is a test string with special characters: ; and /");
        String encoded = encode(strs);
        System.out.println("Encoded string: " + encoded);

        List<String> decoded = decode(encoded);
        System.out.println("Decoded strings: ");
        for (String str : decoded) {
            System.out.println(str);
        }
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == ';') {
                    sb.append("/;");
                }
                else if (s.charAt(i) == '/') {
                    sb.append("//");
                }
                else {
                    sb.append(s.charAt(i));
                }
                i++;
            }
            sb.append(";");
        }

        return sb.toString();
    }

    public static List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();

        StringBuilder currentString = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '/') {
                currentString.append(s.charAt(i + 1));
                i += 2;
            }
            else if (s.charAt(i) != ';') {
                currentString.append(s.charAt(i));
                i++;
            }
            else {
                decodedStrings.add(currentString.toString());
                currentString.setLength(0);
                i++;
            }
        }

        return decodedStrings;
    }
}
