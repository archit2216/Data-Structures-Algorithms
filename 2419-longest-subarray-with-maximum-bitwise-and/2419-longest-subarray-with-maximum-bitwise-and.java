class Solution {
    public int longestSubarray(int[] nums) {
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        
        int c=0;
        int maxVal=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
                c++;
            }else{
                maxVal=Math.max(maxVal,c);
                c=0;
            }
        }
        maxVal=Math.max(maxVal,c);
        return maxVal;
    }
}