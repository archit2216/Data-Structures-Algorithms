class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        
        int currSum=0;
        int netSum=0;
        
        int ans=0;
        for(int i=satisfaction.length-1;i>=0;i--){
            currSum+=netSum+satisfaction[i];
            netSum+=satisfaction[i];
            ans=Math.max(ans,currSum);
        }
        return ans;
    }
}