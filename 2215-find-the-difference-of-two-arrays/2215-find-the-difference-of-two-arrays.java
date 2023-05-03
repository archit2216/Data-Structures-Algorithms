class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans=new ArrayList<>();
        
        HashSet<Integer> hs1=new HashSet<>();
        HashSet<Integer> hs2=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hs1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            hs2.add(nums2[i]);
        }
        List<Integer> al=new ArrayList<>();
        for(int k:hs1){
            if(!hs2.contains(k)){
                al.add(k);
            }
        }
        ans.add(al);
        al=new ArrayList<>();
        for(int k:hs2){
            if(!hs1.contains(k)){
                al.add(k);
            }
        }
        ans.add(al);
        return ans;
    }
}