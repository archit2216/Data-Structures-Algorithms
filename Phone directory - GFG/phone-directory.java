//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        
        Arrays.sort(contact);
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            String pref=s.substring(0,i+1);
            ArrayList<String> al=new ArrayList<>();
            HashSet<String> hs=new HashSet<>();
            for(String cont:contact){
                if(cont.startsWith(pref)){
                    if(!hs.contains(cont)){
                        hs.add(cont);
                        al.add(cont);
                    }
                }
            }
            if(al.size()==0){
                al.add("0");
            }
            ans.add(al);
        }
        return ans;
        // code here
    }
}