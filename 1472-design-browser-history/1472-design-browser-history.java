class BrowserHistory {
    Stack<String> forw;
    Stack<String> back;
    public BrowserHistory(String homepage) {
        forw=new Stack<>();
        back=new Stack<>();
        back.push(homepage);
    }
    
    public void visit(String url) {
        forw=new Stack<>();
        back.push(url);
    }
    
    public String back(int steps) {
        if(steps>=back.size()){
            while(back.size()>1){
                forw.push(back.pop());
            }
        }else{
            while(steps>0){
                forw.push(back.pop());
                steps--;
            }
        }
        if(back.size()==0){
            return null;
        }
        return back.peek();
    }
    
    public String forward(int steps) {
        if(steps>=forw.size()){
            while(forw.size()>0){
                back.push(forw.pop());
            }
        }else{
            while(steps>0){
                back.push(forw.pop());
                steps--;
            }
        }
        if(back.size()==0){
            return null;
        }
        return back.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */