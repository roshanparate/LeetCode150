package hashtable;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean result = validAnagram.isAnagram(s, t);
        System.out.println("Is Anagram: " + result); // Output: true
    }

    public boolean isAnagram(String s, String t) {

        char tempArray[] = s.toCharArray();
        char tempArray1[] = t.toCharArray();

        Arrays.sort(tempArray);
        Arrays.sort(tempArray1);

        return Arrays.equals(tempArray, tempArray1);
    }
}
