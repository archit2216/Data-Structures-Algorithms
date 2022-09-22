class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int limit=(int)Math.pow(2,nums.length);
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<List<Integer>> hs=new HashSet<>();
        for(int i=0;i<limit;i++){
            int temp=i;
            List<Integer> al=new ArrayList<>();
            for(int j=nums.length-1;j>=0;j--){
                int rem=temp%2;
                temp=temp/2;
                if(rem!=0){
                    al.add(nums[j]);
                }
            }
            if(!hs.contains(al)){
                hs.add(al);
                ans.add(al);
            }
        }
        return ans;
    }
}