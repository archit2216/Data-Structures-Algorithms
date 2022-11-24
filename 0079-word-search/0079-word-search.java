class Solution {
    public boolean existHelper(char[][] board,String word,int i,int j,boolean[][] visited,int idx){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j]==true || board[i][j]!=word.charAt(idx)){
            return false;
        }
        
        visited[i][j]=true;
        boolean ans=existHelper(board,word,i-1,j,visited,idx+1) || existHelper(board,word,i,j+1,visited,idx+1) || existHelper(board,word,i,j-1,visited,idx+1)|| existHelper(board,word,i+1,j,visited,idx+1);
        
        visited[i][j]=false;
            return ans;
    }
    
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] visited=new boolean[board.length][board[0].length];
               boolean ans=existHelper(board,word,i,j,visited,0);
                if(ans){
                    return true;
                }
            }
        }
        return false;
    }
}