package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args){

        NQueens nQueens = new NQueens();
        int n = 4;
        List<List<String>> result = nQueens.solveNQueens(n);
        System.out.println("N-Queens Solutions for n = " + n + ":");
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board =  new boolean[n][n];
        return placeNQueensList(board, 0);
    }

    public List<List<String>> placeNQueensList(boolean[][] board, int row){

        if(row == board.length){
            List<List<String>> list = new ArrayList<>();
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board.length; j++){
                    if(board[i][j]){
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            list.add(ans);
            return list;
        }

        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = true;
                list.addAll(placeNQueensList(board, row + 1));
                board[row][i] = false;
            }
        }
        return list;
    }

    public boolean isSafe(boolean[][] board, int row, int col){
        // Check column
        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }

        // diagonal left up
        int maxLeft = Math.min(row, col);
        for(int i = 1; i<= maxLeft; i++){
            if(board[row - i][col - i]){
                return false;
            }
        }

        // diagonal right up
        int maxRight = Math.min(row, board.length - col -1);
        for(int i = 1; i<= maxRight; i++){
            if(board[row - i][col + i]){
                return false;
            }
        }

        return true;
    }
}
