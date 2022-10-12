class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        
        for(int i=nums.length-1;i>=2;i--){
            int per=nums[i]+nums[i-1]+nums[i-2];
            if(nums[i-2]+nums[i-1]>nums[i]){
                max=Math.max(max,per);
            }
        }
        return max;
    }
}