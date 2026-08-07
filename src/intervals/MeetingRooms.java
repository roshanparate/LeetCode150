package intervals;

import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        boolean result = meetingRooms.canAttendMeetings(intervals);
        System.out.println("Can attend all meetings: " + result); // Output: Can attend all meetings: false
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}
