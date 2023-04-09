class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        int[] arr=new int[spells.length];
        
        for(int i=0;i<spells.length;i++){
            int beg=0;
            int end=potions.length-1;
            
            while(beg<=end){
                int mid=beg+(end-beg)/2;
                if((long)spells[i]*(long)potions[mid]>=success){
                    end=mid-1;
                }else{
                    beg=mid+1;
                }
            }
            arr[i]=potions.length-beg;
        }
        return arr;
    }
}