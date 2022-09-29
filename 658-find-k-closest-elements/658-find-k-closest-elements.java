class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int[] arr=new int[nums.length];
        int si=-1;
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            arr[i]=Math.abs(nums[i]-x);
            if(minDiff>Math.abs(nums[i]-x)){
                minDiff=Math.abs(nums[i]-x);
                si=i;
            }
        }
        int i=si-1;
        int j=si+1;
        int count=1;
        List<Integer> al=new ArrayList<>();
        al.add(nums[si]);
        
        while(count<k){
            if(i>=0 && j<arr.length && arr[i]<arr[j]){
                al.add(nums[i]);
                i--;
            }else if(i>=0 && j<arr.length && arr[i]>arr[j]){
                al.add(nums[j]);
                j++;
            }else if(i>=0 && j<arr.length && arr[i]==arr[j]){
                al.add(nums[i]);
                i--;
            }else if(i>=0){
                al.add(nums[i]);
                i--;
            }else if(j<arr.length){
                al.add(nums[j]);
                j++;
            }
            count++;
        }
        Collections.sort(al);
        return al;
    }
}