package twopointer;

public class TwoSum2InputArrayIsSorted {

    public static void main(String[] args) {
        TwoSum2InputArrayIsSorted twoSum2InputArrayIsSorted = new TwoSum2InputArrayIsSorted();
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = twoSum2InputArrayIsSorted.twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
        // Output: Indices: 1, 2
    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int[] ans = new int[2];

        while(start < end){
            if((numbers[start] + numbers[end]) == target){
                ans[0] =  start+1;
                ans[1] =  end+1;
                return ans;
            }else if((numbers[start] + numbers[end]) > target){
                end--;
            }else{
                start++;
            }
        }

        return ans;
    }
}
