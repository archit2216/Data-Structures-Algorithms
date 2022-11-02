class Solution {
    int min;
    public boolean mutation(String s,String t){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i)){
                count++;
            }
        }
        if(count>1){
            return false;
        }
        return true;
    }
    public void solve(String start,String end,String[] bank,int count,boolean[] visited){
        if(start.equals(end)){
            min=Math.min(min,count);
            return;
        }
        
        for(int i=0;i<bank.length;i++){
            if(visited[i]==false && mutation(start,bank[i])){
                visited[i]=true;
                solve(bank[i],end,bank,count+1,visited);
                visited[i]=false;
            }
        }
    }
    public int minMutation(String start, String end, String[] bank) {
        min=Integer.MAX_VALUE;
        boolean[] visited=new boolean[bank.length];
        solve(start,end,bank,0,visited);
        if(min==Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}