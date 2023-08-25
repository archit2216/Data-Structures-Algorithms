class Solution {
    public boolean helper(String s1,String s2,String s3,int i,int j,int k,Boolean[][] dp){
        if(k==s3.length()){
            if(i==s1.length()){
                if(j==s2.length()){
                    return true;
                }
            }
            return false;
        }
        if(i<s1.length() && j<s2.length() && dp[i][j]!=null){
            return dp[i][j];
        }
        
        if(i<s1.length() && j<s2.length() && s1.charAt(i)==s3.charAt(k) && s2.charAt(j)==s3.charAt(k)){
            boolean incs1=helper(s1,s2,s3,i+1,j,k+1,dp);
            boolean incs2=helper(s1,s2,s3,i,j+1,k+1,dp);
            dp[i][j]=(incs1||incs2);
            return (incs1||incs2);
        }
        else if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            boolean incs1=helper(s1,s2,s3,i+1,j,k+1,dp);
            return incs1;
        }else if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            boolean incs2=helper(s1,s2,s3,i,j+1,k+1,dp);
            return incs2;
        }
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()==0){
            if(s1.length()==0 && s2.length()==0){
                return true;
            }else{
                return false;
            }
        }
        Boolean[][] dp=new Boolean[s1.length()][s2.length()];
        boolean ans=helper(s1,s2,s3,0,0,0,dp);
        return ans;
    }
}