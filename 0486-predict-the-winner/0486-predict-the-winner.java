class Solution {
    public int solve(int i,int j,int[] nums){
        if(i>j){
            return 0;
        }
        
        int incI=nums[i]+Math.min(solve(i+2,j,nums),solve(i+1,j-1,nums));
        int incJ=nums[j]+Math.min(solve(i,j-2,nums),solve(i+1,j-1,nums));
        return Math.max(incI,incJ);
    }
    public boolean PredictTheWinner(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int s1=solve(0,nums.length-1,nums);
        if(sum-s1>s1){
            return false;
        }
        return true;
    }
}