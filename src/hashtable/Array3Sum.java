package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array3Sum {

    public static void main(String[] args) {
        Array3Sum array3Sum = new Array3Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = array3Sum.threeSum(nums);
        System.out.println(result); // Output: [[-1, -1, 2], [-1, 0, 1]]
    }

    // Finds all unique triplets in the array which gives the sum of zero.
    // Approach: sort the array and use a fixed element + two-pointer scan for the remaining
    // two elements. Skips duplicates to ensure unique triplets in the result.
    public List<List<Integer>> threeSum(int[] nums) {

        // If input is null or empty nothing to do (original code returns null here).
        if(nums == null || nums.length == 0) return null;

        // Sort first so we can use two-pointer and easily skip duplicates.
        Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through nums and treat nums[i] as the first number of the triplet.
        for(int i = 0; i < len; i++){

            // Skip duplicate values for the first position to avoid duplicate triplets.
            // i == 0: always process the first element. Otherwise, only process when
            // current value differs from the previous value.
            if (i == 0 || (i - 1 >= 0 && nums[i-1] != nums[i])) {

                // Two-pointer initialization for the subarray to the right of i.
                int fp = i + 1;          // front pointer
                int lp = len - 1;        // last pointer
                int target = -nums[i];   // we want nums[fp] + nums[lp] == target

                // Move pointers towards each other while they don't cross.
                while(fp != lp && fp < lp){

                    // Skip duplicates for the front pointer: if current front equals previous
                    // front (and previous front is within the window) then advance fp.
                    if (fp - 1 >= i + 1 && nums[fp-1] == nums[fp]) {
                        fp++;
                        continue;
                    }

                    // Skip duplicates for the last pointer: if current last equals the next
                    // last (and next last is within the window) then decrement lp.
                    if (lp + 1 <= len - 1 && nums[lp+1] == nums[lp]) {
                        lp--;
                        continue;
                    }

                    int sum = nums[fp] + nums[lp];

                    // If sum too large, move left to reduce sum; if too small, move right.
                    if(sum > target){
                        lp--;
                    } else if(sum < target){
                        fp++;
                    } else {
                        // Found a valid triplet.
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[fp]);
                        list.add(nums[lp]);

                        // Move both pointers inward to look for other pairs.
                        fp++;
                        lp--;

                        ans.add(list);
                    }
                }
            }
        }

        return ans;
    }
}
