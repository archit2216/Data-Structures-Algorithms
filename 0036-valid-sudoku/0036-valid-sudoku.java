class Solution {
    public boolean isSafe(char[][] board,int row,int col){
        for(int i=0;i<board.length;i++){
            if(i!=row && board[i][col]==board[row][col]){
                return false;
            }
        }
        
        for(int j=0;j<board[0].length;j++){
            if(j!=col && board[row][j]==board[row][col]){
                return false;
            }
        }
        
        int startR=row/3*3;
        int startC=col/3*3;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if((startR+i)!=row && (startC+j)!=col && board[startR+i][startC+j]==board[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(!isSafe(board,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}