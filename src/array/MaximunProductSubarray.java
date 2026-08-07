package array;

public class MaximunProductSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                // swap max and min
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
