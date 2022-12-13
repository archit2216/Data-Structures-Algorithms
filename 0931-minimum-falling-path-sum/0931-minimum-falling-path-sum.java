class Solution {
    public int solve(int i,int j,int[][] matrix,Integer[][] dp){
        if(i==matrix.length-1 && j>=0 && j<matrix[0].length){
            return matrix[i][j];
        }
        if(j<0 || j>=matrix[0].length){
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        return dp[i][j]=matrix[i][j]+Math.min(solve(i+1,j,matrix,dp),Math.min(solve(i+1,j+1,matrix,dp),solve(i+1,j-1,matrix,dp)));
    }
    public int minFallingPathSum(int[][] matrix) {
        int ans=Integer.MAX_VALUE;
        Integer[][] dp=new Integer[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            ans=Math.min(ans,solve(0,j,matrix,dp));
        }
        return ans;
    }
}