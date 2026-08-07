package intervals;

public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int result = searchInsertPosition.searchInsert(nums, target);
        System.out.println("Insert Position: " + result); // Output: Insert Position: 2
    }


    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return start;
    }
}
