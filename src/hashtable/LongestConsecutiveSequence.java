package hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutiveSequence.longestConsecutive(nums);
        System.out.println("Longest Consecutive Sequence Length: " + result); // Output: 4
    }


    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int ans = 1;
        for(int num : set){
            int count = 1 ;
            if(!set.contains(num-1)){
                int newInt = num+1;
                while(set.contains(newInt)){
                    count++;
                    newInt++;
                }

                if(count > ans){
                    ans = count;
                }
            }
        }
        return ans;
    }
}
