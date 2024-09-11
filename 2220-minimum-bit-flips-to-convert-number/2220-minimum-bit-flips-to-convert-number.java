class Solution {
    public int minBitFlips(int start, int goal) {
        String x=Integer.toBinaryString(start);
        String y=Integer.toBinaryString(goal);
        int count=0;
        String add="";
        if(x.length()>y.length()){
            int diff=x.length()-y.length();
            for(int i=0;i<diff;i++){
                add+='0';
            }
            y=add+y;
        }else{
            int diff=y.length()-x.length();
            for(int i=0;i<diff;i++){
                add+='0';
            }
            x=add+x;
        }
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)!=y.charAt(i)){
                count++;
            }
        }
        return count;
    }
}