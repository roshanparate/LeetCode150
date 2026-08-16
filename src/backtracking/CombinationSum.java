package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum (LeetCode)
 *
 * Problem summary:
 * Given an array of distinct positive integers `candidates` and a target integer
 * `target`, return a list of all unique combinations of `candidates` where the
 * chosen numbers sum to `target`. The same number may be chosen from
 * `candidates` an unlimited number of times. The solution set must not contain
 * duplicate combinations (order of numbers within a combination does not matter).
 *
 * Approach (Backtracking / DFS):
 * - We use a recursive helper `com` that explores two choices at each index:
 *   1) take the current candidate (and stay at the same index because we can
 *      reuse the same number unlimited times), or
 *   2) skip the current candidate and move to the next index.
 * - We maintain a running `target` (remaining sum) and a `list` holding the
 *   current combination. When we reach the end of the candidates array, if the
 *   remaining `target` is 0 we add a copy of the current combination to the
 *   answer list `ans`.
 *
 * Notes on correctness and complexity:
 * - The recursion ensures we consider combinations in non-decreasing order of
 *   indices which prevents duplicates (e.g., [2,3] and [3,2]).
 * - Time complexity is exponential in the worst case (roughly O(n^(target/min)))
 *   because we can pick the same element many times; n is number of
 *   candidates. Space complexity is O(target/min) for the recursion depth and
 *   current combination storage.
 *
 * Implementation details:
 * - `ans` is a list of lists that collects all valid combinations.
 * - `combinationSum` initializes recursion.
 * - `com(int[] candidates, int index, int target, List<List<Integer>> ans,
 *    ArrayList<Integer> list)` parameters:
 *     - `candidates`: input numbers
 *     - `index`: current candidate index we're deciding on
 *     - `target`: remaining sum to reach 0
 *     - `ans`: accumulator for valid combinations
 *     - `list`: current combination (modified in-place during recursion)
 * - When including a candidate, we add it to `list`, recurse with reduced
 *   target, then remove the last added element to backtrack. We use
 *   `list.remove(list.size() - 1)` to pop the last element from an
 *   ArrayList (there is no `removeLast()` method on ArrayList).
 */
public class CombinationSum {

    // Accumulate all valid combinations here
    List<List<Integer>> ans = new ArrayList<>();
    
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println("Combination Sum: " + combinationSum.combinationSum(candidates, target)); // Output: Combination Sum: [[2, 2, 3], [7]]
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        com(candidates, 0, target,ans, new ArrayList<>());
        return ans;

    }

    public void com(int[] candidates, int index, int target,List<List<Integer>>ans, ArrayList<Integer> list){

        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        // If current candidate can fit into remaining target, choose it.
        if(candidates[index] <= target){
            list.add(candidates[index]);
            // stay on same index because we can reuse this candidate
            com(candidates, index, target-candidates[index], ans, list);
            // backtrack: remove the last element we added
            list.remove(list.size() - 1);
        }

        com(candidates, index+1, target, ans, list);
    }
}
