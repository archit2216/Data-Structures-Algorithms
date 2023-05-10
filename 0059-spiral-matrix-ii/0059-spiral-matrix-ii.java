class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        
        int count=1;
        int rs=0;
        int re=n-1;
        int cs=0;
        int ce=n-1;
        while(count<=n*n){
            for(int i=cs;i<=ce;i++){
                ans[rs][i]=count;
                count++;
            }
            rs++;
            for(int i=rs;i<=re;i++){
                ans[i][ce]=count;
                count++;
            }
            ce--;
            for(int i=ce;i>=cs;i--){
                ans[re][i]=count;
                count++;
            }
            re--;
            for(int i=re;i>=rs;i--){
                ans[i][cs]=count;
                count++;
            }
            cs++;
        }
        return ans;
    }
}