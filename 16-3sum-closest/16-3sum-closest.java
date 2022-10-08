class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int maxSum=Integer.MIN_VALUE;
        int diff=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target){
                    return sum;
                }else if(sum<target){
                    if(diff>target-sum){
                        diff=target-sum;
                        maxSum=sum;
                    }
                    j++;
                }else{
                    if(diff>sum-target){
                        diff=sum-target;
                        maxSum=sum;
                    }
                    k--;
                }
            }
        }
        return maxSum;
    }
}