class Solution {
    int m=1000000007;
    public int dfs(int i,int j,int[][] grid,Integer[][] dp,int prev){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]<=prev){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        
        int p1=dfs(i+1,j,grid,dp,grid[i][j]);
        int p2=dfs(i,j+1,grid,dp,grid[i][j]);
        int p3=dfs(i,j-1,grid,dp,grid[i][j]);
        int p4=dfs(i-1,j,grid,dp,grid[i][j]);
        dp[i][j]=(p1+p2+p3+p4+1)%m;
        return (p1+p2+p3+p4+1)%m;
    }
    public int countPaths(int[][] grid) {
        Integer[][] dp=new Integer[grid.length][grid[0].length];
        long ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans+=dfs(i,j,grid,dp,-1);
                ans%=m;
            }
        }
        return (int)(ans%m);
    }
}