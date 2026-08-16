package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println("Combination Sum II: " + combinationSumII.combinationSum2(candidates, target)); // Output: Combination Sum II: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans =  new ArrayList<>();
        Arrays.sort(candidates);
        combII(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }


    public void combII(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> tmp){

        if(target == 0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i= index; i < candidates.length; i++){

            if( i > index && candidates[i] == candidates[i-1]) continue;

            if(candidates[i] > target) break;

            tmp.add(candidates[i]);
            combII(candidates, target-candidates[i], i+1,ans, tmp);
            tmp.removeLast();
        }
    }
}
