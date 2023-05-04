class Solution {
    public String predictPartyVictory(String senate) {
        
        Queue<Integer> r=new ArrayDeque<>();
        Queue<Integer> d=new ArrayDeque<>();
        
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='D'){
                d.add(i);
            }else{
                r.add(i);
            }
        }
        while(r.size()>0 && d.size()>0){
            int r_ind=r.remove();
            int d_ind=d.remove();
            if(r_ind<d_ind){
                r.add(r_ind+senate.length());
            }else{
                d.add(d_ind+senate.length());
            }
        }
        if(r.size()>d.size()){
            return "Radiant";
        }
        return "Dire";
    }
}