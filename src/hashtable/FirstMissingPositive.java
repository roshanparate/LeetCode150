package hashtable;

/**
 * Find the smallest missing positive integer from an unsorted integer array.
 *
 * This class demonstrates the cyclic sort / index-placement technique which runs in
 * O(n) time and uses O(1) extra space (modifies the input array in-place).
 */
public class FirstMissingPositive {

    /**
     * Tiny runner / smoke test for the algorithm.
     * The example array {3,4,-1,1} should produce 2 as the first missing positive.
     */
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        int result = firstMissingPositive.firstMissingPositive(nums);
        System.out.println("First Missing Positive: " + result); // Output: 2
    }

    /**
     * Returns the smallest missing positive integer from the array.
     *
     * Approach (index-placement / cyclic sort):
     * - For any value v in the range [1, n] (n = nums.length), place v at index v-1.
     * - Iterate through the array and swap values into their "correct" indices until
     *   every index either contains the correct value or the current value is out of
     *   the valid range / already correct.
     * - After this rearrangement, the first index i that does not have value i+1
     *   indicates that i+1 is the smallest missing positive. If all indices are
     *   correct, the answer is n+1.
     *
     * Note: This method modifies the input array in-place.
     */
    public int firstMissingPositive(int[] nums) {
        int index = 0;
        // Place each number in its correct position (value v -> index v-1) when possible
        while(index < nums.length){
            int correctIndex = nums[index] - 1; // target index for the current value
            // Only swap when the current value is a positive integer within array bounds
            // and is not already in the correct position. Otherwise move on.
            if(nums[index]> 0 && nums[index] <nums.length && nums[index] != nums[correctIndex]){
                swap(nums, correctIndex, index);
            }else{
                index++;
            }
        }

        // After placement, the first position i that doesn't have i+1 is the answer
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1){
                return i+1;
            }
            i++;
        }
        // If all values 1..n are present, the smallest missing positive is n+1
        return nums.length+1;

    }

    /** Simple helper to swap two elements in the array. */
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
