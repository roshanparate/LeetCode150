package binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray finder = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = finder.searchRange(nums, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]"); // Output: First and Last Position: [3, 4]
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findLeft(nums,target), findRight(nums,target)};
    }

    public int findLeft(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(nums[mid] > target){
                end = mid-1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }

    public int findRight(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(nums[mid] > target){
                end = mid-1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
}
