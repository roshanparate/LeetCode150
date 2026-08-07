package mathandgeometry;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        setMatrixZeroes.setZeroes(matrix);
        System.out.println("Modified Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Sets all elements in a matrix to 0 if that element's row or column contains a 0.
     *
     * Algorithm Explanation:
     * - Uses O(1) space by utilizing the first row and first column as markers
     * - Must check if first row/column originally contain 0s before using them as markers
     * - Process:
     *   1. Check if first row/column have any zeros (store in flags)
     *   2. Use matrix[i][0] and matrix[0][j] as markers for rows/columns to set to 0
     *   3. Iterate through matrix (excluding first row/col) and mark zeros
     *   4. Use markers to set appropriate elements to 0
     *   5. Handle first row/column separately based on original flags
     *
     * Time Complexity: O(m * n) where m = rows, n = columns
     * Space Complexity: O(1) - only uses matrix itself for markers
     */
    public void setZeroes(int[][] matrix) {

        // Flags to track if first row and first column originally contain zeros
        // Must be stored separately since we'll use them as markers later
        boolean firstRow= false, firstCol=false;
        int m = matrix.length, n= matrix[0].length;

        // Check if the first row contains any zeros
        for(int j=0 ; j < n; j++){
            if(matrix[0][j]==0){
                firstRow = true;
                break;
            }
        }

        // Check if the first column contains any zeros
        for(int i=0 ; i < m; i++){
            if(matrix[i][0]==0){
                firstCol = true;
                break;
            }
        }

        // First pass: Mark rows and columns that need to be zeroed
        // Iterate from (1,1) to avoid overwriting our markers in first row/col yet
        for(int i=1 ; i < m; i++){
            for(int j=1 ; j < n; j++){
                if(matrix[i][j]==0){
                    // Mark this row and column by setting first row and first column to 0
                    matrix[i][0] = 0;  // Mark row i
                    matrix[0][j] = 0;  // Mark column j
                }
            }
        }

        // Second pass: Use markers to set elements to 0
        // If row marker (matrix[i][0]) or column marker (matrix[0][j]) is 0, set to 0
        for(int i=1 ; i < m; i++){
            for(int j=1 ; j < n; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row: Set all elements to 0 if it originally contained a 0
        if(firstRow){
            for(int i=0 ; i < n; i++){
                matrix[0][i] = 0;
            }
        }

        // Handle first column: Set all elements to 0 if it originally contained a 0
        if(firstCol){
            for(int i=0 ; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
