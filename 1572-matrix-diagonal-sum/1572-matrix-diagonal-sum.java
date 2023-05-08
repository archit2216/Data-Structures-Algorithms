class Solution {
    public int diagonalSum(int[][] mat) {
        int primsum=0;
        int secsum=0;
        if(mat.length%2!=0){
            for(int i=0,j=0;i<mat.length;i++,j++){
                primsum+=mat[i][j];
            }
            for(int i=0,j=mat.length-1;i<mat.length;i++,j--){
                if(i!=mat.length/2){
                    secsum+=mat[i][j];
                }
            }
        }else{
            for(int i=0,j=0;i<mat.length;i++,j++){
                primsum+=mat[i][j];
            }
            for(int i=0,j=mat.length-1;i<mat.length;i++,j--){
                secsum+=mat[i][j];
            }
        }
        return primsum+secsum;
    }
}