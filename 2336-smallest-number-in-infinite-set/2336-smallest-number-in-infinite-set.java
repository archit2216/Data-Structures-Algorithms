class SmallestInfiniteSet {
    TreeSet<Integer> hs;
    int count;
    public SmallestInfiniteSet() {
        hs=new TreeSet();
        count=1;
    }
    
    public int popSmallest() {
        if(hs.size()>0){
            int top=hs.first();
            if(top<count){
                hs.remove(top);
                return top;
            }else if(top==count){
                hs.remove(top);
                count++;
                return top;
            }else{
                int val=count;
                count++;
                return val;
            }
        }else{
            int val=count;
            count++;
            return val;
        }
    }
    
    public void addBack(int num) {
        hs.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */