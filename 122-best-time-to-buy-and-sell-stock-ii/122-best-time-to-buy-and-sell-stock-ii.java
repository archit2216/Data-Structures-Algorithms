class Solution {
    public int maxProfit(int[] prices) {
        int si=0;
        int ei=0;
        int sum=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=prices[ei]){
                if(si<ei && prices[ei]-prices[si]>0){
                    sum+=prices[ei]-prices[si];
                }
                si=i;
                ei=i;
            }else{
                ei=i;
            }
        }
        if(si<ei && prices[ei]-prices[si]>0){
            sum+=prices[ei]-prices[si];
        }
        return sum;
    }
}