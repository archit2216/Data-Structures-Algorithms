class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                sum+=nums[i];
            }
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int val=queries[i][0];
            int idx=queries[i][1];
            if(nums[idx]%2==0){
                sum-=nums[idx];
                nums[idx]+=val;
                if(nums[idx]%2==0){
                    sum+=nums[idx];
                }
            }else{
                nums[idx]+=val;
                if(nums[idx]%2==0){
                    sum+=nums[idx];
                }
            }
            ans[i]=sum;
        }
        return ans;
    }
}