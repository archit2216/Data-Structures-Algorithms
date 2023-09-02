class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> hs=new HashSet<>();
        for(String str:dictionary){
            hs.add(str);
        }
        
        int[] dp=new int[s.length()+1];
        dp[0]=0;
        
        for(int i=1;i<=s.length();i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                String sub=s.substring(j,i);
                if(hs.contains(sub)){
                    min=Math.min(min,dp[j]);
                }else{
                    min=Math.min(min,dp[i-1]+1);
                }
            }
            dp[i]=min;
        }
        return dp[s.length()];
    }
}