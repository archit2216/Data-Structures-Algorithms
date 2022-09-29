class Solution {
    public int getMaxMoney(int[] nums,int si,int ei){
        int inc=0;
        int exc=0;
        for(int i=si;i<=ei;i++){
            int temp=inc;
            inc=exc+nums[i];
            exc=Math.max(temp,exc);
        }
        return Math.max(inc,exc);
    }
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        
        return Math.max(getMaxMoney(nums,0,nums.length-2),getMaxMoney(nums,1,nums.length-1));
    }
}