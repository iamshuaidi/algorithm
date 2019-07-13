package leetcode;

public class NO36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(!isValid(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col){
        // 行
        for(int i = 0; i < 9; i++){
            if(i != row && board[row][col] == board[i][col]){
                return false;
            }
        }
        // 列
        for(int j = 0; j < 9; j++){
            if(j != col && board[row][j] == board[row][col]){
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
