class Solution {
    public int maxProfit(int[] prices) {
        int maxP=0;
        int minSoFar=prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minSoFar){
                minSoFar=prices[i];
            }
            maxP=Math.max(maxP,prices[i]-minSoFar);
        }
        return maxP;
    }
}