package binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {


    public static void main(String[] args) {
        KokoEatingBananas koko = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int minEatingSpeed = koko.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + minEatingSpeed); // Output: Minimum eating speed: 4
    }

    public int minEatingSpeed(int[] piles, int h){
        int start = 1;
        int end = Arrays.stream(piles).max().orElse(0);
        int ans=0;

        while(start<end){
            int speed = start +(end-start)/2;
            int noOfHourse = calculateHours(piles,speed);
            if(noOfHourse > h){
                start = speed+1;
            }else{
                ans = speed;
                end = speed-1;
            }
        }

        return ans;
    }

    public int calculateHours(int[] piles, int speed){
        int hours=0;
        for(int pile:piles){
            hours += Math.ceil((double)pile/speed);
        }
        return hours;
    }
}
