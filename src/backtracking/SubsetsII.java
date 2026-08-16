package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        int[] nums = {1, 2, 2};
        System.out.println("Subsets II: " + subsetsII.subsetsWithDup(nums)); // Output: Subsets II: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subSetII(nums, ans, list, 0);
        return ans;

    }

    public void subSetII(int[] nums, List<List<Integer>> ans, List<Integer> list, int index){

        ans.add(new ArrayList<>(list));

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            subSetII(nums, ans, list, i+1);
            list.remove(list.size()-1);
        }

    }
}
