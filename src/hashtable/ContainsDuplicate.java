package hashtable;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums)); // Output: true
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(Integer num : nums){
            if(mp.containsKey(num)){
                return true;
            }
            mp.put(num, mp.getOrDefault(num , 0) + 1);
        }
        return false;
    }
}
