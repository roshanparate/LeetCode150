package twopointer;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = containerWithMostWater.maxArea(height);
        System.out.println("Max Area: " + result);
        // Output: Max Area: 49
    }

    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int max = 0;

        while(start < end) {
            int tempMax = 0;
            if(height[end] < height[start]){
                tempMax = height[end] * (end - start);
                end--;
            }else if(height[end] > height[start]){
                tempMax = height[start] * (end - start);
                start++;
            }else{
                tempMax = height[start] * (end - start);
                start++;
            }
            max = Math.max(max, tempMax);
        }

        return max;

    }
}
