package intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mergeIntervals.merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        // Output: Merged Intervals: [1, 6] [8, 10] [15, 18]
    }


    public int[][] merge(int[][] intervals) {

        Arrays.sort(
                intervals, (a,b) -> {
                    if(a[0] < b[0]){
                        return -1;
                    }else if(a[0] > b[0]){
                        return 1;
                    }else{
                        return a[1]-b[1];
                    }
                }
        );

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for(int i=1; i < intervals.length; i++){
            int[] lastInterval = ans.get(ans.size()-1);
            int[] currentInterval = intervals[i];

            if(currentInterval[0] <= lastInterval[1]){
                int[] newInterval = new int[]{Math.min(lastInterval[0], currentInterval[0]),
                        Math.max(lastInterval[1], currentInterval[1])};
                ans.remove(ans.size()-1);
                ans.add(newInterval);
            }else{
                ans.add(currentInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
