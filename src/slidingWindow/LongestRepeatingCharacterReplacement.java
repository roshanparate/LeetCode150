package slidingWindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        int result = longestRepeatingCharacterReplacement.characterReplacement(s, k);
        System.out.println("Longest Repeating Character Replacement: " + result); // Output: 4
    }

    /**
     * Finds the length of the longest substring with at most k character replacements.
     * Uses sliding window technique with a frequency counter.
     * 
     * @param s the input string
     * @param k maximum number of character replacements allowed
     * @return the length of the longest substring after at most k replacements
     * 
     * Algorithm:
     * - Use two pointers (start and end) to maintain a sliding window
     * - Expand window by moving end pointer, track character frequency
     * - If window length - max frequency > k, shrink window from start
     * - Update max length as we go
     * Time Complexity: O(n) where n is the length of string
     * Space Complexity: O(26) = O(1) for the frequency array
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        // Array to store frequency of each character (A-Z)
        int[] count = new int[26];

        // Track the maximum frequency of any character in current window
        int maxCount = 0;
        // Track the longest valid substring length found so far
        int maxLength = 0;
        // Left pointer of the sliding window
        int start = 0;

        // Right pointer of the sliding window - expand window by moving end
        for(int end = 0; end < n; end++){
            // Increment count for current character and update maxCount
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            
            // If characters that need to be replaced exceed k, shrink window from left
            // Window length - most frequent character = characters that need replacement
            while(end - start + 1 - maxCount > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }
            
            // Update the maximum length of valid window found
            maxLength = Math.max(maxLength, end - start + 1);
        }


        return maxLength;
    }
}
