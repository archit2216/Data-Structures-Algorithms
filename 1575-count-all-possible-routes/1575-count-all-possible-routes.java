class Solution {
    int mod=1000000007;
    public int solve(int[] locations,int curr,int finish,int fuel,Integer[][] dp){
        if(fuel<0){
            return 0;
        }
        
        if(dp[curr][fuel]!=null){
            return dp[curr][fuel];
        }
        int ans=0;
        if(curr==finish){
            ans=1;
        }
        
        for(int nextCity=0;nextCity<locations.length;nextCity++){
            if(nextCity!=curr){
                ans=(ans+solve(locations,nextCity,finish,fuel-Math.abs(locations[curr]-locations[nextCity]),dp))%mod;
            }
        }
        dp[curr][fuel]=ans%mod;
        return ans%mod;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        Integer[][] dp=new Integer[locations.length][fuel+1];
        return solve(locations,start,finish,fuel,dp)%mod;
    }
}