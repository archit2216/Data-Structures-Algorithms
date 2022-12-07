class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }
        }
        
        ArrayList<Character> al=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            al.add(ch);
        }
        
        Collections.sort(al,new Comparator<Character>(){
             public int compare(Character a,Character b){
                 int f1=hm.get(a);
                 int f2=hm.get(b);
                 if(f1!=f2){
                    return f2-f1;
                }
                 return a-b;
             }
         });
        
        StringBuilder sb=new StringBuilder();
        for(Character ch:al){
            sb.append(ch);
        }
        return sb.toString();
    }
}