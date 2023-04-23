class Solution {
    public int solve(int idx,String s,int k,Integer[] dp){
        if(idx==s.length()){
            return 1;
        }
        if(s.charAt(idx)=='0'){
            return 0;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        int ans=0;
        long n=0;
        for(int j=idx;j<s.length();j++){
            n=n*10+(int)(s.charAt(j)-'0');
            if(n>k){
                break;
            }
            ans+=solve(j+1,s,k,dp);
            ans%=1000000007;
        }
        
        dp[idx]=ans;
        return ans;
    }
    public int numberOfArrays(String s, int k) {
        Integer[] dp=new Integer[s.length()];
        return solve(0,s,k,dp);
    }
}