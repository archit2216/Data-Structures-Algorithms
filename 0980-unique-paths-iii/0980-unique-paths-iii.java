class Solution {
    int count;
    public void solve(int i,int j,int ei,int ej,int[][] grid,int empty){
        if(i==ei && j==ej){
            if(empty==0){
                count++;
            }
            return;
        }
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1){
            return;
        }
        
        grid[i][j]=-1;
        empty--;
        solve(i-1,j,ei,ej,grid,empty);
        solve(i,j-1,ei,ej,grid,empty);
        solve(i,j+1,ei,ej,grid,empty);
        solve(i+1,j,ei,ej,grid,empty);
        empty++;
        grid[i][j]=0;
    }
    public int uniquePathsIII(int[][] grid) {
        int si=0;
        int sj=0;
        int ei=0;
        int ej=0;
        int empty=1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    si=i;
                    sj=j;
                }
                else if(grid[i][j]==2){
                    ei=i;
                    ej=j;
                }else if(grid[i][j]==0){
                    empty++;
                }
            }
        }
        
        count=0;
        solve(si,sj,ei,ej,grid,empty);
        return count;
    }
}