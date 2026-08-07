package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayFeature {
    public static void main(String[] args) {

        int[] arr = new int[5];
        // fill the array with 0s value at all index
        Arrays.fill(arr, 0);

        System.out.println("Array after filling with 0s: " + Arrays.toString(arr));

        int[] arr2 = new int[]{23,45,87,95,15,36,48,59,62,71};
        int length = arr2.length;

        // sort the array in ascending order
        Arrays.sort(arr2);
        System.out.println("Array after sorting: " + Arrays.toString(arr2));

        // search for an element in the array
        int index = Arrays.binarySearch(arr2, 36);
        System.out.println("Element found at index: " + index);
        int ind = Arrays.binarySearch(arr2, 5);
        System.out.println("Element 5 found at index: " + ind);

        // binary search in range
        int ind1 = Arrays.binarySearch(arr2,0,5, 48);
        System.out.println("Element 48 found at index: " + ind1);

        int ind2 = Arrays.binarySearch(arr2,5,length-1, 48);
        System.out.println("Element 48 found at index: " + ind2);


        List<Integer> list = Arrays.asList(2,8,4,7,5,6,9,2,3);
        Collections.sort(list);
        System.out.println("List after sorting: " + list);

        Pair[] pairList =  new Pair[4];
        pairList[0] = new Pair(1, 8);
        pairList[1] = new Pair(3, 6);
        pairList[2] = new Pair(5, 6);
        pairList[3] = new Pair(7, 8);

        Arrays.sort(pairList);
        System.out.println("Pair array after sorting:" + Arrays.toString(pairList));

    }
}
class Pair implements Comparable<Pair> {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair other){
        if(this.second != other.second){
            return this.second - other.second;
        } else {
            return this.first - other.first;
        }
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

