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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> ans=new ArrayList<>();
        HashSet<String> hs=new HashSet<>();
        int limit=1;
        for(int i=2;i<=S.length();i++){
            limit*=i;
        }
        
        for(int i=0;i<limit;i++){
            int temp=i;
            StringBuilder sb=new StringBuilder(S);
            StringBuilder sb2=new StringBuilder();
            for(int div=S.length();div>=1;div--){
                int q=temp/div;
                int rem=temp%div;
                sb2.append(sb.charAt(rem));
                sb.deleteCharAt(rem);
                temp=q;
            }
            if(!hs.contains(sb2.toString())){
                ans.add(sb2.toString());
                hs.add(sb2.toString());
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}