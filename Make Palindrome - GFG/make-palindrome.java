//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
        if(n==1){
            return false;
        }
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder(arr[i]);
            boolean flag=true;
            if(hs.contains(sb.toString())){
                flag=false;
                hs.remove(sb.toString());
            }
            if(flag){
                hs.add((sb.reverse()).toString());
            }
        }
        if(hs.size()==1){
            for(int i=0;i<n;i++){
                if(hs.contains(arr[i])){
                    int si=0;
                    int ei=arr[i].length()-1;
                    while(si<ei){
                        if(arr[i].charAt(si)!=arr[i].charAt(ei)){
                            return false;
                        }
                        si++;
                        ei--;
                    }
                    return true;
                }
            }
        }
        if(hs.size()==0){
            return true;
        }
        return false;
    }
}
        
