class Solution {
    public int countOrders(int n) {
        long m=1000000007;
        long[] dp=new long[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            long spaces=2*i+1;
            long perms=(spaces*(spaces+1))/2;
            dp[i]=(dp[i-1]*perms)%m;
        }
        
        return (int)(dp[n-1]%m);
    }
}