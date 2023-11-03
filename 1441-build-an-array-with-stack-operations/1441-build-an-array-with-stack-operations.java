class Solution {
    public List<String> buildArray(int[] target, int n) {
        int i=1;
        List<String> ans=new ArrayList<>();
        
        int x=0;
        Stack<Integer> st=new Stack<>();
        
        while(i<=target[target.length-1]){
            if(i==target[x]){
                ans.add("Push");
                st.push(i);
                x++;
            }else{
                int count=0;
                while(i<target[x]){
                    ans.add("Push");
                    count++;
                    i++;
                }
                // count--;
                while(count>0){
                    ans.add("Pop");
                    count--;
                }
                st.push(i);
                ans.add("Push");
                x++;
            }
            i++;
        }
        return ans;
    }
}