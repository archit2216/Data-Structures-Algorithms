class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int size;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        size=0;
    }
    
    public void addNum(int num) {
        if(size%2==0){
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
        }else{
            minHeap.add(num);
            maxHeap.add(minHeap.remove());
        }
        size++;
    }
    
    public double findMedian() {
        if(size%2==0){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }else{
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */