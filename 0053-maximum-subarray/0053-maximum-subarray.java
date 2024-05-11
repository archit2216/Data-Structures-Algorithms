class Solution {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int min=nums[0];
        int max=nums[0];
        
        for(int i=1;i<nums.length;i++){
            int temp=max;
            max=Math.max(nums[i],Math.max(min+nums[i],temp+nums[i]));
            min=Math.min(nums[i],Math.min(max+nums[i],min+nums[i]));
            if(res<max){
                res=max;
            }
        }
        return res;
    }
}