class Solution {
    public boolean isSafe(int row,int col,char[][] board,int num){
        
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]==num){
                return false;
            }
        }
        
        int startRow=row/3*3;
        int startCol=col/3*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[startRow+i][startCol+j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solve(int row,int col,char[][] board){
        if(row==board.length-1 && col==board[0].length){
            return true;
        }
        
        if(col==board[0].length){
            row++;
            col=0;
        }
        
        
        if(board[row][col]!='.'){
            return solve(row,col+1,board);
        }else{
            for(char num='1';num<='9';num++){
                if(isSafe(row,col,board,num)){
                    board[row][col]=num;
                    if(solve(row,col+1,board)){
                        return true;
                    }
                    board[row][col]='.';
                }
            }
        }
        
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }
}