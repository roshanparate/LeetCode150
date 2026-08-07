package mathandgeometry;

public class RotateImageInPlace {

    public static void main(String[] args) {
        RotateImageInPlace rotateImageInPlace = new RotateImageInPlace();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotateImageInPlace.rotate(matrix);
        System.out.println("Rotated Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Rotates a square matrix 90 degrees clockwise in-place.
     * 
     * The rotation is achieved in two steps:
     * 1. Transpose the matrix: swap matrix[i][j] with matrix[j][i]
     *    This converts rows to columns and columns to rows.
     * 2. Reverse each row: flip the elements in each row from left to right.
     *    This completes the 90-degree clockwise rotation.
     * 
     * Example: [[1,2,3],[4,5,6],[7,8,9]]
     * After transpose: [[1,4,7],[2,5,8],[3,6,9]]
     * After reverse rows: [[7,4,1],[8,5,2],[9,6,3]]
     * 
     * Time Complexity: O(n^2) where n is the dimension of the matrix
     * Space Complexity: O(1) since we rotate in-place
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        // Swap elements at matrix[i][j] and matrix[j][i]
        // Only iterate j from i+1 to avoid swapping the same pair twice
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to complete the 90-degree clockwise rotation
        for(int i = 0; i < n; i++){
            int start = 0, end = n - 1;
            // Use two pointers to reverse the row from both ends
            while(start < end){
                // Swap elements from the start and end of the row
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

    }
}
