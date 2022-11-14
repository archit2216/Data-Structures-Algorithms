class Solution {
    long mod=1000000007;
    public int find(int target,int zero,int one,Integer[] dp){
        if(target<0){
            return 0;
        }
        if(target==0){
            return 1;
        }
        if(dp[target]!=null){
            return dp[target];
        }
        
        int x=find(target-zero,zero,one,dp);
        int y=find(target-one,zero,one,dp);
        dp[target]=(int)((x+y)%mod);
        return (int)((x+y)%mod);
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        long ans=0;
        Integer[] dp=new Integer[high+1];
        for(int i=low;i<=high;i++){
            ans+=find(i,zero,one,dp);
            ans%=mod;
        }
        return (int)(ans%mod);
    }
}