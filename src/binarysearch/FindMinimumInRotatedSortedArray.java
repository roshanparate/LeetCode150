package binarysearch;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray finder = new FindMinimumInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = finder.findMin(nums);
        System.out.println("Minimum element in the rotated sorted array: " + min); // Output: Minimum element in the rotated sorted array: 0
    }

    public int findMin(int[] nums) {
        int start = 0;
        int end= nums.length-1;
        int ans = nums[0];

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] >= nums[0]){
                start = mid+1;
            }else if(nums[mid] < nums[0]){
                ans = nums[mid];
                end = mid-1;
            }
        }
        return ans;
    }
}
