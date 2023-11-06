class SeatManager {
    TreeSet<Integer> hs;
    public SeatManager(int n) {
        hs=new TreeSet<>();
        for(int i=1;i<=n;i++){
            hs.add(i);
        }
    }
    
    public int reserve() {
        int temp=hs.pollFirst();
        return temp;
    }
    
    public void unreserve(int seatNumber) {
        hs.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */