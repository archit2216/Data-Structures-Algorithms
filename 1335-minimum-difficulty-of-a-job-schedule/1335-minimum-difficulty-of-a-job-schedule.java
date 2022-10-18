class Solution {
    public int solve(int idx,int[] arr,int d,Integer[][] dp){
        if(idx==arr.length){
            if(d==0){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(d<=0){
            return Integer.MAX_VALUE;
        }
        
        if(dp[idx][d]!=null){
            return dp[idx][d];
        }
        int max=arr[idx];
        int min=Integer.MAX_VALUE;
        for(int i=idx;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            int x=solve(i+1,arr,d-1,dp);
            if(x!=Integer.MAX_VALUE){
                min=Math.min(min,max+x);
            }
        }
        
        dp[idx][d]=min;
        return min;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d){
            return -1;
        }
        
        Integer[][] dp=new Integer[jobDifficulty.length][d+1];
        return solve(0,jobDifficulty,d,dp);
    }
}