//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int longestPerfectPiece(int[] arr, int N) {
        // code here
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        int si=0;
        int j=0;
        int maxLen=0;
        
        while(j<arr.length){
            if(!hm.containsKey(arr[j])){
                hm.put(arr[j],1);
            }else{
                int v=hm.get(arr[j]);
                hm.put(arr[j],v+1);
            }
            
            while(hm.lastKey()-hm.firstKey()>1){
                int val=hm.get(arr[si]);
                if(val==1){
                    hm.remove(arr[si]);
                }else{
                    hm.put(arr[si],val-1);
                }
                si++;
            }
            if(hm.lastKey()-hm.firstKey()<=1){
                maxLen=Math.max(maxLen,j-si+1);
            }
            j++;
        }
        return maxLen;
    }
}