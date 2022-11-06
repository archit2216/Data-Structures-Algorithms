class Solution {
    public class Pair implements Comparable<Pair>{
        int val;
        int idx;
        Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        public int compareTo(Pair o){
            if(this.val!=o.val){
                return this.val-o.val;
            }
            return this.idx-o.idx;
        }
    }
    public long totalCost(int[] costs, int k, int cand) {
        PriorityQueue<Pair> pq1=new PriorityQueue<>();
        PriorityQueue<Pair> pq2=new PriorityQueue<>();
        
        int i=0;
        int j=costs.length-1;
        
        int count=0;
        long sum=0;
        
        
        while(i<=j && count<k){
            if(pq1.size()==cand && pq2.size()==cand){
                Pair p1=pq1.peek();
                Pair p2=pq2.peek();
                if(p1.val<p2.val){
                    sum+=pq1.remove().val;
                }else if(p1.val>p2.val){
                    sum+=pq2.remove().val;
                }else{
                    if(p1.idx!=p2.idx){
                        sum+=pq1.remove().val;
                    }else{
                        sum+=pq1.remove().val;
                        pq2.remove();
                    }
                }
                count++;
            }
            if(pq1.size()<cand){
                pq1.add(new Pair(costs[i],i));
                i++;
            }
            if(pq2.size()<cand){
                pq2.add(new Pair(costs[j],j));
                j--;
            }
        }
        
        while(count<k){
            Pair p1=new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
            Pair p2=new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
            if(pq1.size()>0){
                p1=pq1.peek();
            }
            if(pq2.size()>0){
                p2=pq2.peek();
            }
            if(p1.val<p2.val){
                sum+=pq1.remove().val;
            }else if(p1.val>p2.val){
                sum+=pq2.remove().val;
            }else{
                if(p1.idx!=p2.idx){
                    sum+=pq1.remove().val;
                }else{
                    sum+=pq1.remove().val;
                    pq2.remove();
                }
            }
            count++;
        }
        return sum;
    }
}