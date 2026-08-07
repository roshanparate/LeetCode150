package sorting;

import java.util.Arrays;

public class SortColour {

    public static void main(String [] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColour(arr);
        System.out.print("Sorted array: " + Arrays.toString(arr));

    }

    public static void sortColour(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
