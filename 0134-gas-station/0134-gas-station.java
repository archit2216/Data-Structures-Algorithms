class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int diff=0;
        int cap=0;
        
        for(int i=0;i<gas.length;i++){
            cap+=gas[i]-cost[i];
            if(cap<0){
                diff+=cap;
                start=i+1;
                cap=0;
            }
        }
        if(cap+diff>=0){
            return start;
        }
        return -1;
    }
}