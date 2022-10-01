class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        hm.put(0,-1);
        int sum=0;
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum--;
            }else{
                sum++;
            }
            if(sum==0){
                maxLen=Math.max(maxLen,i+1);
            }
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }else{
                maxLen=Math.max(maxLen,i-hm.get(sum));
            }
        }
        return maxLen;
    }
}