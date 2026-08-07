package binarysearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray searcher = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = searcher.search(nums, target);
        System.out.println("Index of target " + target + ": " + index); // Output: Index of target 0: 4
    }

    public int search(int[] nums, int target) {
        int pointOfRotation = findPOR(nums);

        if(pointOfRotation==0){
            return bSearch(nums,0,nums.length-1,target);
        }

        if (target >= nums[0]) {
            return bSearch(nums, 0, pointOfRotation - 1, target);
        } else {
            return bSearch(nums, pointOfRotation, nums.length - 1, target);
        }
    }

    public int bSearch(int[] nums, int start, int end, int target) {
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] > target){
                end = mid-1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int findPOR(int[] nums){
        int start = 0;
        int end= nums.length-1;
        int pointOfRotation=0;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] >= nums[0]){
                start = mid+1;
            }else {
                pointOfRotation = mid;
                end = mid-1;
            }
        }
        return pointOfRotation;
    }
}
