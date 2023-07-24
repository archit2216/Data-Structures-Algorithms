class Solution {
    public double solve(double x,int n){
        if(n==0){
            return 1;
        }
        
        if(n%2==0){
            return solve(x*x,n/2);
        }else{
            return x*solve(x*x,n/2);
        }
    }
    public double myPow(double x, int n) {
        double ans=solve(x,Math.abs(n));
        
        if(n<0){
            ans=1/ans;
        }
        return ans;
    }
}