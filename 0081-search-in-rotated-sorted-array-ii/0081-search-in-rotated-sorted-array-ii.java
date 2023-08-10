class Solution {
    public boolean search(int[] arr, int target) {
        int beg=0;
        int end=arr.length-1;
        int mid=(beg+end)/2;
        while(beg<=end){
            if(arr[mid]==target){
                return true;
            }else if(arr[beg]<arr[mid]){  //left part sorted
                if(target<arr[mid] && target>=arr[beg]){  //target in sorted area
                    end=mid-1;
                }else{
                    beg=mid+1;
                }
            }else if(arr[beg]>arr[mid]){  //right part sorted
                 if(target>arr[mid] && target<=arr[end]){ //target in sorted area
                     beg=mid+1;
                 }else{
                     end=mid-1;
                 }
            }else{
                beg++;
            }
            mid=(beg+end)/2;
        }
        return false;
    }
}