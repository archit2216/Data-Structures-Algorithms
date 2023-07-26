class Solution {
    public double solve(int[] dist,int speed){
        double total=0;
        
        for(int i=0;i<dist.length;i++){
            double t=(dist[i]*1.0)/speed;
            if(i!=dist.length-1){
                total+=Math.ceil(t);
            }else{
                total+=t;
            }
        }
        return total;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour<dist.length-1){
            return -1;
        }
        int beg=1;
        int end=1000000000;
        int last=-1;
        while(beg<=end){
            int mid=beg+(end-beg)/2;
            if(solve(dist,mid)<=hour){
                last=mid;
                end=mid-1;
            }else{
                beg=mid+1;
            }
        }
        return last;
    }
}