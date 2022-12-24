class Solution {
    public int numTilings(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int m=1000000007;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        dp[2]=5;
        for(int i=3;i<n;i++){
            dp[i]=(2*dp[i-1]%m)+(dp[i-3]%m);
            dp[i]%=m;
        }
        return dp[n-1]%m;
    }
}