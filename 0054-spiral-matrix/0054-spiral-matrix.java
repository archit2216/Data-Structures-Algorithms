class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int count=1;
        int rs=0;
        int re=matrix.length-1;
        int cs=0;
        int ce=matrix[0].length-1;
        List<Integer> al=new ArrayList<>();
        while(count<=matrix.length*matrix[0].length){
            for(int j=cs;j<=ce;j++){
                if(count<=matrix.length*matrix[0].length){
                al.add(matrix[rs][j]);
                count++;
                }
            }
            rs++;
            for(int i=rs;i<=re;i++){
                if(count<=matrix.length*matrix[0].length){
                al.add(matrix[i][ce]);
                count++;
                }
            }
            ce--;
            for(int j=ce;j>=cs;j--){
                if(count<=matrix.length*matrix[0].length){
                al.add(matrix[re][j]);
                count++;
                }
            }
            re--;
            for(int i=re;i>=rs;i--){
                if(count<=matrix.length*matrix[0].length){
                al.add(matrix[i][cs]);
                count++;
                }
            }
            cs++;
        }
        return al;
    }
}