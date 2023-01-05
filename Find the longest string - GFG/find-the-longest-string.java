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
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String longestString(int n, String[] arr) {
        // code here
        
        Arrays.sort(arr,new Comparator<String>(){
           public int compare(String s1,String s2){
               if(s1.length()!=s2.length()){
                   return s1.length()-s2.length();
               }else{
                   return s1.compareTo(s2);
               }
           } 
        });
        
        HashSet<String> hs=new HashSet<>();
        
        int max=0;
        String ans="";
        
        for(int i=0;i<arr.length;i++){
            StringBuilder sb=new StringBuilder();
            boolean flag=true;
            for(int j=0;j<arr[i].length()-1;j++){
                sb.append(arr[i].charAt(j));
                if(!hs.contains(sb.toString())){
                    flag=false;
                    break;
                }
            }
            if(flag){
                if(max<arr[i].length()){
                    max=arr[i].length();
                    ans=arr[i];
                }
            }
            hs.add(arr[i]);
        }
        
        return ans;
    }
}
        
