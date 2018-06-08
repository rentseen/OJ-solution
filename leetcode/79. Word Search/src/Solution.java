public class Solution {
    public boolean dfs(char[][] board, boolean[][] flag, String word, int index, int x, int y) {
        if(index==word.length())
            return true;
        if(x-1>=0 && !flag[x-1][y] && board[x-1][y]==word.charAt(index)) {
            flag[x-1][y] = true;
            if(dfs(board, flag, word, index+1, x-1, y)) {
                return true;
            }
            flag[x-1][y] = false;
        }
        if(x+1<board.length && !flag[x+1][y] && board[x+1][y]==word.charAt(index)) {
            flag[x+1][y] = true;
            if(dfs(board, flag, word, index+1, x+1, y)) {
                return true;
            }
            flag[x+1][y] = false;
        }
        if(y-1>=0 && !flag[x][y-1] && board[x][y-1]==word.charAt(index)) {
            flag[x][y-1] = true;
            if(dfs(board, flag, word, index+1, x, y-1)) {
                return true;
            }
            flag[x][y-1] = false;
        }
        if(y+1<board[0].length && !flag[x][y+1] && board[x][y+1]==word.charAt(index)) {
            flag[x][y+1] = true;
            if(dfs(board, flag, word, index+1, x, y+1)) {
                return true;
            }
            flag[x][y+1] = false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] flag= new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    flag[i][j] = true;
                    if(dfs(board, flag, word, 1, i, j)) {
                        return true;
                    }
                    flag[i][j] = false;
                }
            }
        }
        return false;
    }
}
