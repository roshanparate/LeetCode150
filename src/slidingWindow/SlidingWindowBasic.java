package slidingWindow;

public class SlidingWindowBasic {
    public static void main(String[] args) {
        // Example array
        int[] arr = {10, 2, 7, 8, 11, 13};

        /**
         * Sliding Window (fixed-size) explanation:
         *
         * The sliding window technique is used to efficiently compute values (sum, max, etc.)
         * over all contiguous subarrays (windows) of a fixed size k in an array of length n.
         *
         * Naive approach: For each starting index i, compute the sum of the k elements in O(k).
         * Doing this for all (n-k+1) windows costs O(n*k).
         *
         * Sliding window optimization: Compute the sum for the first window (indices 0..k-1).
         * Then for each next window shift (i -> i+1) update the sum in O(1) by:
         *    new_sum = old_sum - outgoing_element + incoming_element
         * where outgoing_element is arr[i] and incoming_element is arr[i+k].
         * This yields O(n) time overall and O(1) extra space.
         */

        int k = 4, sum = 0, n = arr.length;
        if (k <= 0) {
            System.out.println("Window size k must be > 0");
            return;
        }
        if (k > n) {
            System.out.println("Window size k is larger than array length; no windows to compute.");
            return;
        }

        System.out.println("Array: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
        System.out.println("Window size k = " + k + "\n");

        // compute sum of first window [0 .. k-1]
        System.out.print("Initial window elements: ");
        for (int i = 0; i < k; i++) {
            sum += arr[i];
            System.out.print(arr[i] + (i == k - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.println("Sum of window starting at index 0: " + sum);

        // slide the window one element at a time and update the sum in O(1)
        for (int i = 1; i <= n - k; i++) {
            int outgoing = arr[i - 1];
            int incoming = arr[i + k - 1];
            // update sum by removing outgoing and adding incoming
            int oldSum = sum;
            sum = sum - outgoing + incoming;

            System.out.println();
            System.out.println("Move window to start at index " + i + ":");
            System.out.println("  outgoing element (removed) = arr[" + (i - 1) + "] = " + outgoing);
            System.out.println("  incoming element (added)  = arr[" + (i + k - 1) + "] = " + incoming);
            System.out.println("  updated sum = " + oldSum + " - " + outgoing + " + " + incoming + " = " + sum);
            System.out.print("  window elements: ");
            for (int j = i; j < i + k; j++) {
                System.out.print(arr[j] + (j == i + k - 1 ? "" : ", "));
            }
            System.out.println();
        }
    }




}
