class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        
        int i=0;
        int j=grid[0].length-1;
        
        while(i<grid.length){
            if(j>=0 && grid[i][j]<0){
                j--;
                count++;
            }else{
                j=grid[0].length-1;
                i++;
            }
        }
        return count;
    }
}