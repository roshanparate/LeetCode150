package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subSets;

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println("Subsets: " + subsets.subsets(nums)); // Output: Subsets: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.subSets = new ArrayList<>();

        List<Integer> subSet = new ArrayList<>();
        backTracking(0, subSet, nums);

        return this.subSets;
    }

    public void backTracking(int i , List<Integer> subSet, int[] nums){
        if(i >= nums.length){
            this.subSets.add(new ArrayList(subSet));
        }else{
            backTracking(i+1, subSet, nums);

            subSet.add(nums[i]);
            backTracking(i+1, subSet, nums);
            subSet.remove(subSet.size()-1);
        }
    }
}
