class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int beg=0;
        int end=arr.length-1;
        
        while(end-beg>=k){
            if(Math.abs(arr[beg]-x)>Math.abs(arr[end]-x)){
                beg++;
            }else{
                end--;
            }
        }
        
        List<Integer> al=new ArrayList<>();
        for(int i=beg;i<=end;i++){
            al.add(arr[i]);
        }
        return al;
    }
}