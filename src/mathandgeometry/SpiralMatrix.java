package mathandgeometry;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> mat = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n-1;
        int left = 0, right = m-1;

        while(top <= bottom && left <= right){
            for(int i = left ; i <=right; i++){
                mat.add(matrix[top][i]);
            }
            top++;

            for(int i = top ; i <=bottom; i++){
                mat.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right ; i >=left; i--){
                    mat.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom ; i >=top; i--){
                    mat.add(matrix[i][left]);
                }
                left++;
            }
        }
        return mat;
    }
}
