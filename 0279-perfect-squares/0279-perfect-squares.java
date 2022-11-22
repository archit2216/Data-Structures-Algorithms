class Solution {
    public int numSquares(int n) {
         int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            int j=1;
            int minVal=Integer.MAX_VALUE;
            while(i-j*j>=0){
                minVal=Math.min(minVal,dp[i-j*j]);
                j++;
            }
            dp[i]=minVal+1;
        }
        
        return dp[n];
    }
}