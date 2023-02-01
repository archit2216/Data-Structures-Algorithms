class Solution {
    public String gcdOfStrings(String s1, String s2) {
        if(s1.length()<s2.length()){
            String temp=new String(s1);
            s1=s2;
            s2=temp;
        }
        
        String ans="";
        for(int i=0;i<s2.length();i++){
            String x=s2.substring(0,i+1);
            boolean flag=true;
            int j=0;
            while(j<s1.length()-i){
                if((s1.substring(j,x.length()+j)).equals(x)){
                    j+=x.length();
                    continue;
                }else{
                    flag=false;
                    break;
                }
            }
            int k=0;
            while(k<=s2.length()-k){
                if(s2.substring(k,x.length()+k).equals(x)){
                    k+=x.length();
                    continue;
                }else{
                    flag=false;
                    break;
                }
            }
            if(flag && s1.length()%x.length()==0 && s2.length()%x.length()==0){
                ans=x;
            }
        }
        return ans;
    }
}