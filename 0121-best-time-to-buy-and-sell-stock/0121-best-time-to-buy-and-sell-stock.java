class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int diff=Integer.MIN_VALUE;
        
        for(int i=1;i<prices.length;i++){
            diff=Math.max(prices[i]-min,diff);
            if(prices[i]<min){
                min=prices[i];
            }
        }
        
        if(diff<0){
            return 0;
        }
        return diff;
    }
}