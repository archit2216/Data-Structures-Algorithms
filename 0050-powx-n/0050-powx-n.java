class Solution {
    public double myPow(double x, int n) {
        boolean flag=false;
        if(n<0){
            n=-n;
            flag=true;
        }
        
        double ans=pow(x,n);
        if(flag){
            return 1/ans;
        }
        return ans;
    }
    
    public double pow(double x,int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        
        if(n%2==0){
            return pow(x*x,n/2);
        }else{
            return x*pow(x*x,n/2);
        }
    }
}