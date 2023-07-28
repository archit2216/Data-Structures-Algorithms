class Solution {
    public int solve(int i,int j,int[] nums,Integer[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int incI=nums[i]+Math.min(solve(i+2,j,nums,dp),solve(i+1,j-1,nums,dp));
        int incJ=nums[j]+Math.min(solve(i,j-2,nums,dp),solve(i+1,j-1,nums,dp));
        return dp[i][j]=Math.max(incI,incJ);
    }
    public boolean PredictTheWinner(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        Integer[][] dp=new Integer[nums.length][nums.length];
        int s1=solve(0,nums.length-1,nums,dp);
        if(sum-s1>s1){
            return false;
        }
        return true;
    }
}