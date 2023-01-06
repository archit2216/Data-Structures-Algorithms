class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max=0;
        for(int i=0;i<costs.length;i++){
            max=Math.max(max,costs[i]);
        }
        
        int[] arr=new int[max+1];
        
        for(int i=0;i<costs.length;i++){
            arr[costs[i]]++;
        }
        
        int i=0;
        int count=0;
        while(i<arr.length){
            while(arr[i]>0 && coins>0){
                if(coins>=i){
                    coins-=i;
                    count++;
                }
                arr[i]--;
            }
            i++;
        }
        
        return count;
    }
}