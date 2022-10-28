class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        List<String> al=new ArrayList<>();
        
        List<int[]> arrcheck=new ArrayList<>();
        
        for(int i=0;i<strs.length;i++){
            int[] arr=new int[26];
            String word=strs[i];
            for(int j=0;j<word.length();j++){
                char ch=word.charAt(j);
                arr[ch-'a']++;
            }
            
            if(ans.size()==0){
                al=new ArrayList<>();
                al.add(word);
                ans.add(al);
                arrcheck.add(arr);
            }else{
                boolean flag=false;
                for(int x=0;x<arrcheck.size();x++){
                    int[] secondarr=arrcheck.get(x);
                    if(Arrays.equals(arr,secondarr)){
                        al=ans.get(x);
                        al.add(word);
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    arrcheck.add(arr);
                    al=new ArrayList<>();
                    al.add(word);
                    ans.add(al);
                }
            }
        }
        return ans;
    }
}