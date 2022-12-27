class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] dp=new int[rocks.length];
        
        for(int i=0;i<dp.length;i++){
            dp[i]=capacity[i]-rocks[i];
        }
        
        Arrays.sort(dp);
        int c=0;
        for(int i=0;i<dp.length;i++){
            if(additionalRocks-dp[i]>=0){
                additionalRocks-=dp[i];
                c++;
            }
        }
        return c;
    }
}