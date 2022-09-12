class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int i=0;
        int j=tokens.length-1;
        int max=0;
        int score=0;
        while(i<=j){
            if(tokens[i]<=power){
                power-=tokens[i];
                i++;
                score++;
            }else{
                if(score==0){
                    return 0;
                }
                score--;
                power+=tokens[j];
                j--;
            }
            max=Math.max(max,score);
        }
        return max;
    }
}