package sorting;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int majority = findMajorityElement(arr);
        System.out.println("Majority element: " + majority);
    }

    public static int findMajorityElement(int[] arr) {
        int count = 0;
        Integer candidate = null;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
