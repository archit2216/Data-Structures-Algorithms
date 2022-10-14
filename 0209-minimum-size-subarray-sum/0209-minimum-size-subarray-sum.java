class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size=0;
        int minSize=Integer.MAX_VALUE;
        int sum=0;
        int i=0;
        while(i<nums.length){
            if(sum>=target){
                minSize=Math.min(size,minSize);
                while(sum>=target){
                    if(sum>=target){
                        minSize=Math.min(minSize,size);
                    }
                    sum-=nums[i-size];
                    size--;
                }
            }
            sum+=nums[i];
            size++;
            i++;
        }
        if(sum>=target){
            while(i>=size && sum>=target){
                if(sum>=target){
                    minSize=Math.min(minSize,size);
                }
                sum-=nums[i-size];
                size--;
            }
        }
        if(minSize==Integer.MAX_VALUE){
            return 0;
        }
        return minSize;
    }
}