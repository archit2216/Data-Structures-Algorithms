class Solution {
    public boolean solve(int[] nums,int i,int n,Boolean[] dp){
        if(i>=n){
            return true;
        }
        
        if(dp[i]!=null){
            return dp[i];
        }
        
        boolean ans=false;
        if(i<nums.length-2 && nums[i]+1==nums[i+1] && nums[i+1]+1==nums[i+2]){
            ans|=solve(nums,i+3,n,dp);
        }if(i<nums.length-2 && nums[i]==nums[i+1] && nums[i+1]==nums[i+2]){
            ans|=solve(nums,i+3,n,dp);
        }if(i<nums.length-1 && nums[i]==nums[i+1]){
            ans|=solve(nums,i+2,n,dp);
        }
        
        dp[i]=ans;
        return ans;
    }
    public boolean validPartition(int[] nums) {
        Boolean[] dp=new Boolean[nums.length];
        return solve(nums,0,nums.length,dp);
    }
}