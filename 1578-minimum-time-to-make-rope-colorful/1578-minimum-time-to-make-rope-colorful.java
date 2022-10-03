class Solution {
    public int minCost(String colors, int[] neededTime) {
        String sb="";
        int ans=0;
        int prevVal=0;
        for(int i=0;i<colors.length();i++){
            char ch1=colors.charAt(i);
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=ch1){
                sb+=ch1;
                prevVal=neededTime[i];
            }else{
                if(prevVal>neededTime[i]){
                    ans+=neededTime[i];
                }else{
                    ans+=prevVal;
                    prevVal=neededTime[i];
                }
            }
        }
        return ans;
    }
}