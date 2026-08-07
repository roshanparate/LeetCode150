package intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {

    public static void main(String[] args) {
        NonoverlappingIntervals nonoverlappingIntervals = new NonoverlappingIntervals();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int result = nonoverlappingIntervals.eraseOverlapIntervals(intervals);
        System.out.println("Minimum number of intervals to remove: " + result); // Output: Minimum number of intervals to remove: 1
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));
        int count = 0;
        int end  = intervals[0][1];
        for(int i = 1 ; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0] < end){
                count++;
            }else{
                end = interval[1];
            }
        }
        return count;
    }
}
