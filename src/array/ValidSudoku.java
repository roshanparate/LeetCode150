package array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        ValidSudoku obj = new ValidSudoku();
        boolean isValid = obj.isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + isValid);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] gridSet = new HashSet[9];

        for(int i= 0 ; i < 9 ; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            gridSet[i] = new HashSet<>();
        }

        for(int i = 0 ; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int gridNo =  (j/3) + (i/3) * 3;

                if(board[i][j] != '.'){
                    boolean rowPresent = rowSet[i].contains(board[i][j]);
                    boolean colPresent = colSet[j].contains(board[i][j]);
                    boolean gridPresent = gridSet[gridNo].contains(board[i][j]);

                    if(rowPresent || colPresent || gridPresent){
                        return false;
                    }
                    rowSet[i].add(board[i][j]);
                    colSet[j].add(board[i][j]);
                    gridSet[gridNo].add(board[i][j]);
                }

            }
        }


        return true;
    }
}