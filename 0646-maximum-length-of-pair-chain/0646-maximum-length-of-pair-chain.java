class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,new Comparator<int[]>(){
            public int compare(int[] first,int[] second){
                if(first[0]!=second[0]){
                    return first[0]-second[0];
                }
                return first[1]-second[1];
            }
        });
        
        int max=1;
        int[] dp=new int[pairs.length];
        dp[0]=1;
        for(int i=1;i<pairs.length;i++){
            int j=0;
            int maxLen=0;
            while(j<i){
                if(pairs[i][0]>pairs[j][1]){
                    maxLen=Math.max(maxLen,dp[j]);
                }
                j++;
            }
            dp[i]=maxLen+1;
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}