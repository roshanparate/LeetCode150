package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println("Permutations: " + permutations.permute(nums)); // Output: Permutations: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] feq = new boolean[nums.length];
        calculatePermutation(nums, res, tempList, feq);
        return res;
    }

    public void calculatePermutation(int[] nums, List<List<Integer>> res, List<Integer> tempList, boolean[] feq){
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=0; i <nums.length; i++){
            if(!feq[i]){
                feq[i] =  true;
                tempList.add(nums[i]);
                calculatePermutation(nums, res,tempList, feq);
                tempList.removeLast();
                feq[i] =  false;
            }
        }

    }
}
