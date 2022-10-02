class Solution {
    long ans=0;
    long mod=1000000007;
    public long getSum(int n,int k,int target,Long[][] dp){
        if(target<0){
            return 0;
        }
        if(n==0){
            if(target==0){
               return 1;
            }
            return 0;
        }
        
        if(dp[n][target]!=null){
            return dp[n][target];
        }
        long ans=0;
        for(int i=1;i<=k;i++){
            ans+=(getSum(n-1,k,target-i,dp)%mod);
            ans%=mod;
        }
        dp[n][target]=ans%mod;
        return ans;
    }
    public int numRollsToTarget(int n, int k, int target) {
        Long[][] dp=new Long[n+1][target+1];
        return (int)(getSum(n,k,target,dp)%mod);
    }
}