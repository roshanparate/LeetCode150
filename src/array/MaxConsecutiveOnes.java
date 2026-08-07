package array;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        int maxCount = findMaxConsecutiveOnes(arr);
        System.out.println("Maximum number of consecutive 1s: " + maxCount);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        // Check for the last sequence of 1s
        return Math.max(maxCount, count);
    }
}
