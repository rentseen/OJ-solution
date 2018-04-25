public class Solution {
    public boolean checkRow(char[][] board, int row) {
        boolean[] flag = new boolean[10];
        for(int i=0; i<9; i++) {
            char c = board[row][i];
            if(c!='.') {
                if(flag[c-'0'])
                    return false;
                else
                    flag[c-'0']=true;
            }
        }
        return true;
    }
    public boolean checkCol(char[][] board, int col) {
        boolean[] flag = new boolean[10];
        char c;
        for(int i=0; i<9; i++) {
            c = board[i][col];
            if(c!='.') {
                if(flag[c-'0'])
                    return false;
                else
                    flag[c-'0']=true;
            }
        }
        return true;
    }
    public boolean checkBox(char[][] board, int x, int y) {
        boolean[] flag = new boolean[10];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                char c = board[x+i][y+j];
                if(c!='.') {
                    if(flag[c-'0'])
                        return false;
                    else
                        flag[c-'0']=true;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            if(!checkRow(board, i))
                return false;
            if(!checkCol(board, i))
                return false;
        }
        for(int i=0; i<9; i=i+3) {
            for(int j=0; j<9; j=j+3) {
                if(!checkBox(board, i, j))
                    return false;
            }
        }
        return true;
    }
}
