//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        int count=0;
        for(int i=0;i<S.length();i++){
            int cl=0;
            int cu=0;
            if(Character.isUpperCase(S.charAt(i))){
                cu++;
            }else{
                cl++;
            }
            for(int j=i+1;j<S.length();j++){
                if(Character.isUpperCase(S.charAt(j))){
                    cu++;
                }else{
                    cl++;
                }
                if(cu==cl){
                    count++;
                }
            }
        }
        return count;
        // code here
    }
} 
