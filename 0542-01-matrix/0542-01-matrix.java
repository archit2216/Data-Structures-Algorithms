class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        Queue<int[]> q=new ArrayDeque<>();
        boolean[][] vis=new boolean[mat.length][mat[0].length];
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    q.add(new int[]{i,j});
                }
            }
        }
        while(q.size()>0){
            int[] rem=q.remove();
            for(int k=0;k<4;k++){
                int newI=rem[0]+dx[k];
                int newJ=rem[1]+dy[k];
                
                if(newI<0 || newJ<0 || newI>=mat.length || newJ>=mat[0].length || vis[newI][newJ]==true){
                    continue;
                }else{
                    vis[newI][newJ]=true;
                    mat[newI][newJ]=mat[rem[0]][rem[1]]+1;
                    q.add(new int[]{newI,newJ});
                }
            }
        }
        
        return mat;
    }
}