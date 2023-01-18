class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int currMax=0;
        int currMin=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            currMax=Math.max(nums[i],currMax+nums[i]);
            maxSum=Math.max(maxSum,currMax);
            currMin=Math.min(nums[i],currMin+nums[i]);
            minSum=Math.min(minSum,currMin);
            sum+=nums[i];
        }
        
        if(maxSum>0){
            return Math.max(maxSum,sum-minSum);
        }
        return maxSum;
    }
}