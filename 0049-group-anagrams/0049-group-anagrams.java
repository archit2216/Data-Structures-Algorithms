class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        for(String word:strs){
            char[] arr=word.toCharArray();
            Arrays.sort(arr);
            String sortedStr=String.valueOf(arr);
            if(hm.containsKey(sortedStr)){
                List<String> al=hm.get(sortedStr);
                al.add(word);
                hm.put(sortedStr,al);
            }else{
                List<String> al=new ArrayList<>();
                al.add(word);
                hm.put(sortedStr,al);
            }
        }
        return new ArrayList<>(hm.values());
    }
}