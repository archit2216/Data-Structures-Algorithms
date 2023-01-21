class Solution {
    List<String> al=new ArrayList<>();
    public void restoreIP(String s,int k,int i,String asf,int ssf){
        if(i>s.length()){
            return;
        }
if(ssf>k){
    return;
}
        if(i==s.length()){
            if(ssf==k){
                asf=asf.substring(0,asf.length()-1);
                al.add(asf);
            }
            return;
        }
        
        restoreIP(s,k,i+1,asf+s.charAt(i)+".",ssf+1);
        if(i+2<=s.length() && s.charAt(i)!='0'){
        restoreIP(s,k,i+2,asf+s.substring(i,i+2)+".",ssf+1);
        }
        
        if(i+3<=s.length() && s.charAt(i)!='0' && Integer.parseInt(s.substring(i,i+3))<=255){
        restoreIP(s,k,i+3,asf+s.substring(i,i+3)+".",ssf+1);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        restoreIP(s,4,0,"",0);
        
        return al;
    }
}