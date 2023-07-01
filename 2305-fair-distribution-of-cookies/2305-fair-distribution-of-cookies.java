class Solution {
    int minDiff=Integer.MAX_VALUE;
    public int solve(int idx,int[] arr,int k,int[] currSum){
        if(idx==arr.length){
            int res=0;
            for(int i=0;i<currSum.length;i++){
                res=Math.max(currSum[i],res);
            }
            return res;
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            currSum[i]+=arr[idx];
            ans=Math.min(ans,solve(idx+1,arr,k,currSum));
            currSum[i]-=arr[idx];
        }
        
        return ans;
    }
    public int distributeCookies(int[] cookies, int k) {
        return solve(0,cookies,k,new int[k]);
    }
}