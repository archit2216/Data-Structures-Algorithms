//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        String s=A;
        int count=1;
        while(s.length()<B.length()){
            s+=A;
            count++;
        }
        s+=A;
        count++;
        for(int i=0;i<s.length()-B.length()-1;i++){
            if((s.substring(i,B.length()+i)).equals(B)){
                if(B.length()+i<=s.length()-A.length()){
                    return count-1;
                }else{
                    return count;
                }
            }
        }
        return -1;
    }
};