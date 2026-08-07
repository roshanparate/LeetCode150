package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println("Length of Longest Substring Without Repeating Characters: " + result); // Output: 3
    }


    public int lengthOfLongestSubstring(String s) {
        int ans=0, n=s.length(),fp=0, sp=0;
        Map<Character, Integer> mp = new HashMap<>();
        while(sp < n){
            addToMap(mp, s.charAt(sp));
            while(fp < sp && !isValid(mp)){
                deleteFromMap(mp, s.charAt(fp));
                fp++;
            }
            int len = sp - fp + 1;
            ans =  Math.max(ans, len);
            sp++;
        }
        return ans;
    }

    public void addToMap(Map<Character, Integer> mp, char ch){
        mp.put(ch, mp.getOrDefault(ch,0)+1);
    }

    public void deleteFromMap(Map<Character, Integer> mp, char ch){
        mp.put(ch, mp.get(ch)-1);
    }

    public boolean isValid(Map<Character, Integer> mp){
        for(char ch : mp.keySet()){
            if(mp.get(ch) > 1){
                return false;
            }
        }
        return true;
    }
}
