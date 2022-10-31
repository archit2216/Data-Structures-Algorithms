class Solution {
    public class Pair implements Comparable<Pair>{
        int plant;
        int grow;
        
        Pair(int plant,int grow){
            this.plant=plant;
            this.grow=grow;
        }
        
        public int compareTo(Pair o){
            if(this.grow!=o.grow){
                return o.grow-this.grow;
            }
            return o.plant-this.plant;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Pair[] arr=new Pair[plantTime.length];
        
        for(int i=0;i<arr.length;i++){
            arr[i]=new Pair(plantTime[i],growTime[i]);
        }
        
        Arrays.sort(arr);
        
        int ans=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            ans+=arr[i].plant;
            max=Math.max(max,ans+arr[i].grow);
        }
        return max;
    }
}