package binarysearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    public static void main(String[] args) {
        MagneticForceBetweenTwoBalls solver = new MagneticForceBetweenTwoBalls();
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        int maxForce = solver.maxDistance(position, m);
        System.out.println("Maximum magnetic force: " + maxForce); // Output: Maximum magnetic force: 3
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int start = 1;
        int end =  position[position.length-1] - position[0];
        int ans = 1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(placedBalls(position, mid, m)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return ans;
    }

    public boolean placedBalls(int[] position, int dist, int noOfBalls){
        int ballsPlaced = 1;
        int lastBallsPlacedAt = position[0];

        for(int i = 1; i < position.length && ballsPlaced < noOfBalls; i++){
            if(position[i] >= lastBallsPlacedAt+dist){
                ballsPlaced++;
                lastBallsPlacedAt = position[i];
            }
        }

        return ballsPlaced==noOfBalls;
    }
}
