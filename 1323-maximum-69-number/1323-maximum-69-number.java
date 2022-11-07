class Solution {
    public int maximum69Number (int num) {
        int idx=-1;
        int i=0;
        int n=num;
        while(num>0){
            int x=num%10;
            if(x==6){
                idx=i;
            }
            i++;
            num=num/10;
        }
        if(idx==-1){
            return n;
        }
        
        return n + 3*(int)Math.pow(10,idx);
    }
}