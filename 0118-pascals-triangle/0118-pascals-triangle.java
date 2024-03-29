class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<numRows;i++){
            List<Integer> al=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i==0){
                    al.add(1);
                }else{
                    if(j==0){
                        al.add(ans.get(i-1).get(j));
                    }else if(j==i){
                        al.add(ans.get(i-1).get(j-1));
                    }else{
                        al.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
                    }
                }
            }
            ans.add(al);
        }
       
        return ans;
    }
}