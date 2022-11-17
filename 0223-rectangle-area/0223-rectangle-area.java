class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int total_area=((ax2-ax1)*(ay2-ay1))+((bx2-bx1)*(by2-by1));
        
        if(ax1>=bx2 || bx1>=ax2 || ay1>=by2 || by1>=ay2){
            return total_area;
        }
        
        int left=Math.max(ax1,bx1);
        int right=Math.min(bx2,ax2);
        int bottom=Math.max(by1,ay1);
        int top=Math.min(ay2,by2);
        
        int overlap=(right-left)*(top-bottom);
        
        return total_area-overlap;
    }
}