class StockSpanner {
    
    public class Pair{
        int stock;
        int index;
    }
    
    Stack<Pair> st;
    int idx=0;
    public StockSpanner() {
        st=new Stack<>();
        Pair inf=new Pair();
        inf.index=-1;
        inf.stock=Integer.MAX_VALUE;
        st.push(inf);
    }
    
    public int next(int price) {
        Pair top=new Pair();
        top.stock=price;
        top.index=idx;
        idx++;
        
        while(st.peek().stock<=price){
            st.pop();
        }
        int ans=top.index-st.peek().index;
        st.push(top);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */