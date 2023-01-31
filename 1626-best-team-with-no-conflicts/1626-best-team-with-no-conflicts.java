class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr=new int[scores.length][2];
        for(int i=0;i<scores.length;i++){
            arr[i][0]=scores[i];
            arr[i][1]=ages[i];
        }
        
        Arrays.sort(arr,new Comparator<int[]>(){
           public int compare(int[] first,int[] second){
               if(first[1]!=second[1]){
                   return first[1]-second[1];
               }else{
                   return first[0]-second[0];
               }
           } 
        });
        
        int[] dp=new int[arr.length];
        dp[0]=arr[0][0];
        int max=arr[0][0];
        for(int i=1;i<arr.length;i++){
            int j=0;
            dp[i]=arr[i][0];
            while(j<i){
                if(arr[j][0]<=arr[i][0]){
                    dp[i]=Math.max(dp[i],arr[i][0]+dp[j]);
                }
                j++;
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}