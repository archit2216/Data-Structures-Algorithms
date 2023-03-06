class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count=0;
        int num=0;
        for(int i=0;i<arr.length;i++){
            int x=(arr[i]-num)-1;
            
            if(count+x>=k){
                while(count<k){
                    num++;
                    count++;
                }
                return num;
            }else{
                count+=x;
            }
            num=arr[i];
        }
        while(count<k){
            num++;
            count++;
        }
        return num;
    }
}