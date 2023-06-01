class Solution {
    int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        if(grid[0][0]==1 || grid[m-1][n-1]==1) {
            return -1;
        }

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});

        int ans=0;
        while (!queue.isEmpty()) {
            int size=queue.size();
            for(int i=0;i<size;i++) {
                int[] pop=queue.remove();
                if(pop[0]==n-1 && pop[1]==m-1) {
                    return ans+1;
                }
                for (int k=0;k<8;k++) {
                    int nextX=dir[k][0]+pop[0];
                    int nextY=dir[k][1]+pop[1];

                    if(nextX>=0 && nextX<n && nextY>=0 && nextY<m && !visited[nextX][nextY] && grid[nextX][nextY]==0) {
                        queue.add(new int[]{nextX,nextY});
                        visited[nextX][nextY]=true;
                    }

                }
            }
            ans++;
        }
        return -1;
    }
}