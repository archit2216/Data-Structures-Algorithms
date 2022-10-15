class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int maxIndex=0;
        for(int i=1;i<nums.length;i++){
            int j=0;
            int max=1;
            while(j<i){
                if(nums[i]%nums[j]==0){
                    max=Math.max(max,dp[j]+1);
                }
                j++;
            }
            dp[i]=max;
            if(dp[maxIndex]<dp[i]){
                maxIndex=i;
            }
        }
        
        int number=nums[maxIndex];
        List<Integer> al=new ArrayList<>();
        for(int i=maxIndex;i>=0;i--){
            if(number%nums[i]==0 && dp[maxIndex]-dp[i]<=1){
                al.add(nums[i]);
                maxIndex=i;
                number=nums[i];
            }
        }
        Collections.sort(al);
        return al;
    }
}