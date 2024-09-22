class Solution {
    public void solve(int i,int n,List<Integer> al){
        if(i>n){
            return;
        }
        
        al.add(i);
        for(int j=0;j<=9;j++){
            solve(10*i+j,n,al);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> al=new ArrayList<>();
        for(int i=1;i<=9;i++){
            solve(i,n,al);
        }
        return al;
    }
}