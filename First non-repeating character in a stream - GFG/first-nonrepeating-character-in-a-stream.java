//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String s)
    {
        HashMap<Character,Integer> hm=new HashMap<>();
        Queue<Character> q=new ArrayDeque<>();
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
                while(q.size()>0 && hm.get(q.peek())>1){
                    q.remove();
                }
                if(q.size()==0){
                    sb.append("#");
                }else{
                    sb.append(q.peek()+"");
                }
            }else{
                hm.put(ch,1);
                q.add(ch);
                sb.append(q.peek()+"");
            }
        }
        return sb.toString();
        // code here
    }
}