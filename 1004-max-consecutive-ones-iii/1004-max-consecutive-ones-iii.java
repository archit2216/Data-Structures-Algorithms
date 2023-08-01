class Solution {
    public int longestOnes(int[] nums, int k) {
        int c0=0;
        int max=0;
        int l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c0++;
            }
            
            while(c0>k){
                if(nums[l]==0){
                    c0--;
                }
                l++;
            }
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}