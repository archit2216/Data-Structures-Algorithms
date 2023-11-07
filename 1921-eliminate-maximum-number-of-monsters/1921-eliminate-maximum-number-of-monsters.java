class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int count=0;
        for(int i=0;i<dist.length;i++){
            if(dist[i]<speed[i]){
                dist[i]=1;
            }else{
                int rem=dist[i]%speed[i];
                int q=dist[i]/speed[i];
                dist[i]=q+(rem>0?1:0);
            }
        }
        Arrays.sort(dist);
        int sub=0;
        for(int i=0;i<dist.length;i++){
            if(dist[i]-sub>0){
                count++;
            }else{
                break;
            }
            sub++;
        }
        return count;
    }
}