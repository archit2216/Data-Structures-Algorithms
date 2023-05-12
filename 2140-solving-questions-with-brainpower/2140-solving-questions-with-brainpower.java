class Solution {
    public long solve(int idx,int[][] arr,Long[] dp){
        if(idx>=arr.length){
            return 0;
        }
        
        if(dp[idx]!=null){
            return dp[idx];
        }
        long take=solve(idx+arr[idx][1]+1,arr,dp);
        long notTake=solve(idx+1,arr,dp);
        
        return dp[idx]=Math.max(take+arr[idx][0],notTake);
    }
    public long mostPoints(int[][] questions) {
        Long[] dp=new Long[questions.length];
        return solve(0,questions,dp);
    }
}