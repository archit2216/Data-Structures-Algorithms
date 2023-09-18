class Solution {
    public class Pair implements Comparable<Pair>{
        int idx;
        int val;
        Pair(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
        public int compareTo(Pair o){
            if(this.val==o.val){
                return o.idx-this.idx;
            }
            return o.val-this.val;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] arr=new int[mat.length];
        for(int i=0;i<mat.length;i++){
            int count=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            arr[i]=count;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Pair(i,arr[i]));
        }
        for(int i=k;i<arr.length;i++){
            if(pq.peek().val>arr[i]){
                pq.remove();
                pq.add(new Pair(i,arr[i]));
            }
        }
        arr=new int[k];
        int i=k-1;
        while(pq.size()>0){
            arr[i]=pq.remove().idx;
            i--;
        }
        return arr;
    }
}