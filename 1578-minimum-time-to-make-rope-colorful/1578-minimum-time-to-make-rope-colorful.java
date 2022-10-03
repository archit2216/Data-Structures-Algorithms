class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0;
        int prevVal=0;
        int x=-1;
        for(int i=0;i<colors.length();i++){
            char ch1=colors.charAt(i);
            if(x==-1 || colors.charAt(x)!=ch1){
                prevVal=neededTime[i];
            }else{
                if(prevVal>neededTime[i]){
                    ans+=neededTime[i];
                }else{
                    ans+=prevVal;
                    prevVal=neededTime[i];
                }
            }
            x++;
        }
        return ans;
    }
}