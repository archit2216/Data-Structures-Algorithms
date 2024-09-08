class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        for(int i=0;i<rolls.length;i++){
            sum+=rolls[i];
        }
        
        int totalSum=mean*(n+rolls.length);
        int diff=totalSum-sum;
        
        int q=diff/n;
        
        if(diff<n || diff>6*n){
            return new int[0];
        }
        
        int[] ans=new int[n];
        int rem=diff%n;
        Arrays.fill(ans,q);
        for(int i=0;i<rem;i++){
            ans[i]++;
        }
        
        return ans;
        
        
    }
}