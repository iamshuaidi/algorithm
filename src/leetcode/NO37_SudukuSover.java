package leetcode;

public class NO37_SudukuSover {
    public void solveSudoku(char[][] board) {
        solveSudokuByDFS(board, 0, 0);
    }

    private boolean solveSudokuByDFS(char[][] board, int i, int j){
        if(i == 9)
            return true;
        if(j >= 9)
            return solveSudokuByDFS(board, i + 1, 0);
        if(board[i][j] >= '0' && board[i][j] <= '9')
            return solveSudokuByDFS(board, i, j + 1);
        for(int k = 1; k <= 9; k++){
            board[i][j] = (char)('0' + k);
            if(isValid(board, i, j)){
                if(solveSudokuByDFS(board, i, j + 1)){
                    return true;
                }
            }
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col){

        // 列
        for(int j = 0; j < 9; j++){
            if(j != col && board[row][j] == board[row][col]){
                return false;
            }
        }
        // 行
        for(int i = 0; i < 9; i++){
            if(i != row && board[row][col] == board[i][col]){
                return false;
            }
        }
        int t1 = (row / 3) * 3;
        int t2 = (col / 3) * 3;
        for(int i = t1; i < t1 + 3; i++){
            for(int j = t2; j < t2 + 3; j++){
                if((i != row || j != col) && board[i][j] == board[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}
