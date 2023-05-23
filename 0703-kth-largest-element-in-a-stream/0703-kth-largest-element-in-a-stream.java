class KthLargest {
    PriorityQueue<Integer> pq;
    int cap;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        cap=k;
        for(int i=0;i<nums.length;i++){
            if(pq.size()==k){
                if(pq.peek()<nums[i]){
                    pq.remove();
                    pq.add(nums[i]);
                }
            }else{
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size()==cap && pq.peek()<val){
            pq.remove();
            pq.add(val);
        }else if(pq.size()<cap){
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */