class Solution {
    public int numberOfChild(int n, int k) {
        n--;
        int rem=k%n;
        int q=k/n;
        
        if(q%2==0){
            return rem;
        }else{
            return n-rem;
        }
    }
}