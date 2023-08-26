//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        HashMap<Character,Integer> hm=new HashMap<>();
        int si=0;
        int max=0;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!hm.containsKey(ch)){
                if(hm.size()==k){
                    while(si<i && hm.size()==k){
                        int val=hm.get(s.charAt(si));
                        if(val==1){
                            hm.remove(s.charAt(si));
                        }else{
                            hm.put(s.charAt(si),val-1);
                        }
                        si++;
                    }
                }
                hm.put(ch,1);
            }else{
                hm.put(ch,hm.get(ch)+1);
            }
            if(max<i-si+1){
                max=i-si+1;
            }
        }
        
        // max=Math.max(max,s.length()-si+1);
        if(hm.size()<k){
            return -1;
        }
        return max;
    }
}