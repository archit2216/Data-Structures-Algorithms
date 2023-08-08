class Solution {
    public int search(int[] arr, int target) {
        
        int beg=0;
        int end=arr.length-1;
        int mid=(beg+end)/2;
        while(beg<=end){
            if(arr[mid]==target){
                return mid;
            }else if(arr[beg]<=arr[mid]){  //left part sorted
                if(target<arr[mid] && target>=arr[beg]){
                    end=mid-1;
                }else{
                    beg=mid+1;
                }
            }else{  //right part sorted
                if(target>arr[mid] && target<=arr[end]){
                    beg=mid+1;
                }else{
                    end=mid-1;
                }
            }
            mid=(beg+end)/2;
        }
        return -1;
    }
}