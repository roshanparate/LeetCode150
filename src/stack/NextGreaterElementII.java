package stack;

import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {
        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterElementII.nextGreaterElements(nums);
        System.out.print("Next Greater Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: Next Greater Elements: 2 -1 2
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        int[] ans =  new int[nums.length];

        for(int i=1; i < nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                ans[st.peek()] = nums[i];
                st.pop();
            }
            st.push(i);
        }

        for(int i=0 ; i < nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                ans[st.peek()] = nums[i];
                st.pop();
            }
        }

        while(!st.isEmpty()){
            ans[st.peek()] = -1;
            st.pop();
        }

        return ans;
    }
}
