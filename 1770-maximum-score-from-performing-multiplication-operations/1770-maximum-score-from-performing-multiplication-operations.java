class Solution {
    public int getMaxSum(int i,int j,int[] nums,int[] mul,int idx,Integer[][] dp){
        if(idx==mul.length){
            return 0;
        }
        if(i>j){
            return 0;
        }
        if(dp[idx][i]!=null){
            return dp[idx][i];
        }
        int ls=getMaxSum(i+1,j,nums,mul,idx+1,dp)+nums[i]*mul[idx];
        int rs=getMaxSum(i,j-1,nums,mul,idx+1,dp)+nums[j]*mul[idx];
        dp[idx][i]=Math.max(ls,rs);
        return Math.max(ls,rs);
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] dp=new Integer[multipliers.length][multipliers.length];
        int ans=getMaxSum(0,nums.length-1,nums,multipliers,0,dp);
        return ans;
    }
}