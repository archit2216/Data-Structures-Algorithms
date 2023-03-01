class Solution {
    public void merge(int si,int ei,int m,int[] nums){
        int[] left=new int[m-si+1];
        int[] right=new int[ei-m];
        
        
        for(int i=0;i<left.length;i++){
            left[i]=nums[si+i];
        }
        
        for(int i=0;i<right.length;i++){
            right[i]=nums[m+i+1];
        }
        
        int i=0;
        int j=0;
        int k=si;
        
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                nums[k]=left[i];
                i++;
            }else{
                nums[k]=right[j];
                j++;
            }
            k++;
        }
        
        while(i<left.length){
            nums[k]=left[i];
            i++;
            k++;
        }
        
        while(j<right.length){
            nums[k]=right[j];
            j++;
            k++;
        }
    }
    public void MergeSort(int si,int ei,int[] nums){
        if(si>=ei){
            return;
        }
        
        int mid=(si+ei)/2;
        MergeSort(si,mid,nums);
        MergeSort(mid+1,ei,nums);
        
        merge(si,ei,mid,nums);
    }
    public int[] sortArray(int[] nums) {
        if(nums.length<=1){
            return nums;
        }
        MergeSort(0,nums.length-1,nums);
        return nums;
    }
}