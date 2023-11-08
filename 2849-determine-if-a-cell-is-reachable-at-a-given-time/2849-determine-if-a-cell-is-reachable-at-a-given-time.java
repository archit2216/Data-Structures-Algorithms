class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx==fx && sy==fy){
            if(t==0 || t>1){
                return true;
            }
            return false;
        }
        int diffx=Math.abs(fx-sx);
        int diffy=Math.abs(fy-sy);
        if(Math.max(diffx,diffy)<=t){
            return true;
        }
        return false;
        
    }
}