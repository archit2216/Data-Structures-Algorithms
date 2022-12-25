class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans=new int[queries.length];
        
        Arrays.sort(nums);
        
        for(int i=0;i<queries.length;i++){
            int sum=0;
            int c=0;
            for(int j=0;j<nums.length;j++){
                if(sum+nums[j]<=queries[i]){
                    sum+=nums[j];
                    c++;
                }else{
                    break;
                }
            }
            ans[i]=c;
        }
        return ans;
    }
}