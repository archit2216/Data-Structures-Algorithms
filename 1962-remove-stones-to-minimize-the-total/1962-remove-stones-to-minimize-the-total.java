class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<piles.length;i++){
            pq.add(piles[i]);
        }
        
        while(k>0){
            int rem=pq.remove();
            if(rem%2==0){
                rem/=2;
            }else{
                rem=(rem+1)/2;
            }
            pq.add(rem);
            k--;
        }
        
        int sum=0;
        while(pq.size()>0){
            sum+=pq.remove();
        }
        return sum;
    }
}