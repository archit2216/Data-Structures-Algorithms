class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int si=1;
        int ei=1000000000;
        while(si<ei){
            int mid=si+(ei-si)/2;
            
            int total=0;
            for(int pile:piles){
                total+=Math.ceil((pile*1.0)/mid);
            }
            if(total>h){
                si=mid+1;
            }else{
                ei=mid;
            }
        }
        
        return si;
    }
}