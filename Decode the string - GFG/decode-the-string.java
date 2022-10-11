//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static String decodedString(String s){
        Stack<String> st=new Stack<>();
        int i=0;
        StringBuilder finalans=new StringBuilder();
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch==']'){
                StringBuilder sb=new StringBuilder();
                while(Character.isDigit(st.peek().charAt(0))==false){
                    sb.append(st.pop());
                }
                StringBuilder n=new StringBuilder(st.pop());
                n.reverse();
                int num=Integer.parseInt(n.toString())-1;
                
                String str=sb.toString();
                for(int j=0;j<num;j++){
                    sb.append(str);
                }
                st.push(sb.toString());
                i++;
            }else if(ch!='['){
                StringBuilder sb=new StringBuilder();
                if(Character.isDigit(s.charAt(i))){
                    while(Character.isDigit(s.charAt(i))){
                        sb.append(s.charAt(i));
                        i++;
                    }
                }else if(Character.isAlphabetic(s.charAt(i))){
                    while(Character.isAlphabetic(s.charAt(i))){
                        sb.append(s.charAt(i));
                        i++;
                    }
                }
                sb.reverse();
                st.push(sb.toString());
            }else{
                i++;
            }
        }
        while(st.size()>0){
            finalans.append(st.pop());
        }
        finalans.reverse();
        return finalans.toString();
        // code here
    }
}