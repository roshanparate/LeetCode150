package twopointer;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trappingRainWater.trap(height);
        System.out.println("Trapped Water: " + result);
        // Output: Trapped Water: 6
    }

    public int trap(int[] height) {

        int ans = 0;
        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];


        left[0] = height[0];
        for(int i =1; i < n; i++){
            left[i] = Math.max(height[i], left[i-1]);
        }

        right[n-1] = height[n-1];
        for(int i = n-2; i >=0; i--){
            right[i] = Math.max(height[i], right[i+1]);
        }

        for(int i=0; i<n; i++){
            ans += (Math.min(right[i], left[i]) - height[i]);
        }
        return ans;

    }
}
