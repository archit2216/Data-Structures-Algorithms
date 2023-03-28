class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay=days[days.length-1];
        int[] dp=new int[lastDay+1];
        
        int x=0;
        for(int i=1;i<=lastDay;i++){
            if(i!=days[x]){
                dp[i]=dp[i-1];
                continue;
            }else{
                dp[i]=costs[0]+dp[i-1];
                dp[i]=Math.min(dp[i],costs[1]+dp[Math.max(i-7,0)]);
                dp[i]=Math.min(dp[i],costs[2]+dp[Math.max(i-30,0)]);
                x++;
            }
        }
        return dp[lastDay];
    }
}