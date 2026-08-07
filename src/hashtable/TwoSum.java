package hashtable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int rem = target - nums[i];
            if(mp.containsKey(rem)){
                int index =  mp.get(rem);
                return new int[]{index, i};
            }else{
                mp.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}
