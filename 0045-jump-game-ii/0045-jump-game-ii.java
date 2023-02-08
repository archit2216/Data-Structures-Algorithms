class Solution {
    public int jump(int[] nums) {
       int farthest=0;
        int jumps=0;
        int maxReach=0;
        int i=0;
        while(i<nums.length && farthest<nums.length-1){
            maxReach=Math.max(maxReach,i+nums[i]);
            if(i==farthest){
                farthest=maxReach;
                jumps++;
            }
            i++;
        }
        return jumps;
    }
}