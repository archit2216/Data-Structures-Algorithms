class Solution {
    public int minPathSum(int[][] arr) {
       
       for(int i=arr.length-1;i>=0;i--){
           for(int j=arr[0].length-1;j>=0;j--){
              if(i==arr.length-1 && j==arr[0].length-1){
                  arr[i][j]=arr[i][j];
              }else if(i==arr.length-1){
                  arr[i][j]=arr[i][j]+arr[i][j+1];
              }else if(j==arr[0].length-1){
                  arr[i][j]=arr[i][j]+arr[i+1][j];
              }else{
                  arr[i][j]=arr[i][j]+Math.min(arr[i+1][j],arr[i][j+1]);
              }
           }
       }
        return arr[0][0];
    }
}