//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int[] arr=new int[26];
            HashSet<Character> hs=new HashSet<>();
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                hs.add(ch);
                arr[ch-'a']++;
                int max=0;
                int min=1000;
                if(hs.size()>1){
                    for(int k=0;k<26;k++){
                        if(arr[k]>0){
                            max=Math.max(max,arr[k]);
                            min=Math.min(min,arr[k]);
                        }
                    }
                    sum+=(max-min);
                }
            }
        }
        return sum;
        // code here
    }
}
        
