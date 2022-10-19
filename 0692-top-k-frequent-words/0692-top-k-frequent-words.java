class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        List<String> al=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(hm.containsKey(words[i])){
                int val=hm.get(words[i]);
                hm.put(words[i],val+1);
            }else{
                al.add(words[i]);
                hm.put(words[i],1);
            }
        }
        
        Collections.sort(al,new Comparator<String>(){
            public int compare(String s1,String s2){
                if(hm.get(s1)!=hm.get(s2)){
                    return hm.get(s2)-hm.get(s1);
                }else{
                    return s1.compareTo(s2);
                }
            }
        });
        return al.subList(0,k);
    }
}