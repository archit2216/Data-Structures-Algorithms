class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int beg=0;
        int end=(matrix.length*matrix[0].length)-1;
        
        
        //Treating the 2d array as a 1d array, where cellNo/col=row and cellNo/col=column
        while(beg<=end){
            int mid=(beg+end)/2;
            int row=mid/matrix[0].length;
            int col=mid%matrix[0].length;
            
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                beg=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}