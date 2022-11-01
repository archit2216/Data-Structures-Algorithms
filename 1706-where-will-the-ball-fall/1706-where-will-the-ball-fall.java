class Solution {
    public int[] findBall(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length-1;j++){
                if(grid[i][j]==1 && grid[i][j+1]==-1){
                    grid[i][j]=0;
                    grid[i][j+1]=0;
                }
            }
        }
        
        int[] arr=new int[grid[0].length];
        for(int i=0;i<grid[0].length;i++){
            arr[i]=i;
        }
        
        if(grid[0][0]==-1){
            arr[0]=-1;
        }
        if(grid[0][grid[0].length-1]==1){
            arr[grid[0].length-1]=-1;
        }
        
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                if(arr[j]<0 || arr[j]>=grid[0].length){
                    arr[j]=-1;
                    continue;
                }
                if(grid[i][arr[j]]==0){
                    arr[j]=-1;
                    continue;
                }
                arr[j]+=grid[i][arr[j]];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=grid[0].length){
                arr[i]=-1;
            }
        }
        return arr;
    }
}