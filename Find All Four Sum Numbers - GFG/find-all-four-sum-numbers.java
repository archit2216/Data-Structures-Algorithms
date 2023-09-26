//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        HashSet<ArrayList<Integer>> hs=new HashSet<>();
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int si=j+1;
                int ei=arr.length-1;
                while(si<ei){
                    if(arr[i]+arr[j]+arr[si]+arr[ei]==k){
                        ArrayList<Integer> al=new ArrayList<>();
                        al.add(arr[i]);
                        al.add(arr[j]);
                        al.add(arr[si]);
                        al.add(arr[ei]);
                        if(!hs.contains(al)){
                            ans.add(al);
                            hs.add(al);
                        }
                        si++;
                        ei--;
                    }else if(arr[i]+arr[j]+arr[si]+arr[ei]<k){
                        si++;
                    }else{
                        ei--;
                    }
                }
            }
        }
        return ans;
    }
}