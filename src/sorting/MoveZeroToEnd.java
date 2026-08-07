package sorting;

public class MoveZeroToEnd {
    public static void moveZeroToEnd(int[] arr) {
        int len =  arr.length;

        int j = 0;
        for(int i=0 ; i < len; i++) {
            if(arr[i]  != 0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        moveZeroToEnd(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
