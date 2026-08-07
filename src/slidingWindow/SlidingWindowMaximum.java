package slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
        System.out.print("Sliding Window Maximums: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: Sliding Window Maximums: 3 3 5 5 6 7
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> qe = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int n = nums.length;
        qe.offer(0);

        for(int i=0; i<k; i++){
            while(qe.size() > 0 && nums[qe.peekLast()] < nums[i]){
                qe.removeLast();
            }
            qe.offerLast(i);
        }

        ans.add(nums[qe.peek()]);

        for(int j=k; j<n; j++){
            int startingPoint = j-k+1;

            while(qe.size() > 0 && qe.peek() < startingPoint){
                qe.removeFirst();
            }

            while(qe.size() > 0 && nums[qe.peekLast()] < nums[j]){
                qe.removeLast();
            }

            qe.offerLast(j);
            ans.add(nums[qe.peek()]);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
