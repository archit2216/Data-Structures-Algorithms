class Solution {
    int ans;
    public void solve(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1){
            return;
        }
        
        if(i-1>=0 && grid[i-1][j]==0 || i-1<=-1){
            ans+=1;
        }
        if(j-1>=0 && grid[i][j-1]==0 || j-1<=-1){
            ans+=1;
        }
        if(i+1<grid.length && grid[i+1][j]==0 || i+1>=grid.length){
            ans+=1;
        }
        if(j+1<grid[0].length && grid[i][j+1]==0 || j+1>=grid[0].length){
            ans+=1;
        }
        
        grid[i][j]=-1;
        solve(grid,i+1,j);
        solve(grid,i,j+1);
        solve(grid,i,j-1);
        solve(grid,i-1,j);
    }
    public int islandPerimeter(int[][] grid) {
        ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    solve(grid,i,j);
                    return ans;
                }
            }
        }
        return ans;
    }
}