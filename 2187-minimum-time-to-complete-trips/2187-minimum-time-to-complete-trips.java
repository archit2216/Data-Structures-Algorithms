class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long beg=0;
        long end=(long)(Math.pow(10,14));
        
        while(beg<end){
            long mid=beg+(end-beg)/2;
            long tripsTime=0;
            for(int t:time){
                tripsTime+=mid/t;
            }
            if(tripsTime>=totalTrips){
                end=mid;
            }else{
                beg=mid+1;
            }
        }
        return beg;
    }
}