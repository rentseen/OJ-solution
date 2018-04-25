import java.util.ArrayList;

public class Solution {
    public static int flush(char[][] board, boolean[][][] flag, int i, int j) {
        char c = board[i][j];
        if(c!='.') {
            int num = c-'0';
            for(int k=0; k<9; k++) {
                flag[i][k][num]=true;
                flag[k][j][num]=true;
            }
            int x = i/3*3;
            int y = j/3*3;
            for(int m=x; m<x+3; m++) {
                for(int n=y; n<y+3; n++) {
                    flag[m][n][num]=true;
                }
            }
        }
        if(c=='.')
            return 1;
        else return 0;
    }
    public static int flush(char[][] board, boolean[][][] flag) {
        clearFlag(flag);
        int count=0;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                count+=flush(board, flag, i, j);
            }
        }
        return count;
    }
    public static void clearFlag(boolean[][][] flag) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                for(int k=0; k<10; k++) {
                    flag[i][j][k]=false;
                }
            }
        }
    }
    public static boolean preCheck(char[][] board, boolean[][][] flag) {
        boolean result=false;
        for(int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.')
                    continue;
                int count = 0;
                int index=-1;
                for(int k=1; k<=9; k++) {
                    if(!flag[i][j][k]) {
                        index=k;
                        count++;
                    }
                }
                if(count==1) {
                    result=true;
                    board[i][j]=(char)('0'+index);
                }
            }
        }
        return result;
    }
    public static boolean check(char[][] board, boolean[][][] flag) {
        int x=0;
        int y=0;
        int min=20;
        for(int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.')
                    continue;
                int count = 0;
                for(int k=1; k<=9; k++) {
                    if(!flag[i][j][k]) {
                        count++;
                    }
                }
                if(count==0)
                    return false;
                if(min>count) {
                    x=i;
                    y=j;
                    min=count;
                }
            }
        }
        int[] candidate = new int[9];
        int len=0;
        for(int k=1; k<=9; k++) {
            if(!flag[x][y][k]) {
                candidate[len++]=k;
            }
        }
        for(int i=0; i<len; i++) {
            board[x][y]=(char)('0'+candidate[i]);
            if(flush(board, flag)==0)
                return true;
            if(check(board, flag))
                return true;
            board[x][y]='.';
        }
        return false;
    }
    public static void solveSudoku(char[][] board) {
        boolean [][][] flag = new boolean[9][9][10];
        flush(board, flag);
        while (preCheck(board, flag)) {
            flush(board, flag);
        }
        boolean result = check(board, flag);
    }
    public static void main(String[] args) {
        char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        solveSudoku(board);
    }
}
