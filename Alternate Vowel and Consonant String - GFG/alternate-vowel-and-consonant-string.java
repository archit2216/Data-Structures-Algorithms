//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String S, int n){
        int vo=0;
        int co=0;
        
        int[] arr=new int[26];
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            arr[ch-'a']++;
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vo++;
            }else{
                co++;
            }
        }
        
        if(vo>co){
            if(vo-co>1){
                return "-1";
            }
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if(j%2==0){
                    for(int i=0;i<26;i++){
                        if((i==0 || i==4 || i==8 || i==14 || i==20) && arr[i]>0){
                            sb.append((char)('a'+i));
                            arr[i]--;
                            break;
                        }
                    }
                }else{
                    for(int i=0;i<26;i++){
                        if(i!=0 && i!=4 && i!=8 && i!=14 && i!=20 && arr[i]>0){
                            sb.append((char)('a'+i));
                            arr[i]--;
                            break;
                        }
                    }
                }
        }
        return sb.toString();
        }else if(vo<co){
            if(co-vo>1){
                return "-1";
            }
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if(j%2!=0){
                    for(int i=0;i<26;i++){
                        if((i==0 || i==4 || i==8 || i==14 || i==20) && arr[i]>0){
                            sb.append((char)('a'+i));
                            arr[i]--;
                            break;
                        }
                    }
                }else{
                    for(int i=0;i<26;i++){
                        if(i!=0 && i!=4 && i!=8 && i!=14 && i!=20 && arr[i]>0){
                            sb.append((char)('a'+i));
                            arr[i]--;
                            break;
                        }
                    }
                }
        }
                return sb.toString();
        }
        else{
            if(vo==0 && co==0){
                return "";
            }else{
                StringBuilder sb=new StringBuilder();
                boolean f=false;
                for(int i=0;i<26;i++){
                    if(arr[i]>0 && (i==0 || i==4 || i==8 || i==14 || i==20)){
                        f=true;
                        break;
                    }else if(arr[i]>0){
                        f=false;
                        break;
                    }
                }
                
                if(f){
                    for(int j=0;j<n;j++){
                        if(j%2==0){
                            for(int i=0;i<26;i++){
                                if((i==0 || i==4 || i==8 || i==14 || i==20) && arr[i]>0){
                                    sb.append((char)('a'+i));
                                    arr[i]--;
                                    break;
                                }
                            }
                        }else{
                            for(int i=0;i<26;i++){
                                if(i!=0 && i!=4 && i!=8 && i!=14 && i!=20 && arr[i]>0){
                                    sb.append((char)('a'+i));
                                    arr[i]--;
                                    break;
                                }
                            }
                        }
                }
                }else{
                    for(int j=0;j<n;j++){
                if(j%2!=0){
                    for(int i=0;i<26;i++){
                        if((i==0 || i==4 || i==8 || i==14 || i==20) && arr[i]>0){
                            sb.append((char)('a'+i));
                            arr[i]--;
                            break;
                        }
                    }
                }else{
                    for(int i=0;i<26;i++){
                        if(i!=0 && i!=4 && i!=8 && i!=14 && i!=20 && arr[i]>0){
                            sb.append((char)('a'+i));
                            arr[i]--;
                            break;
                        }
                    }
                }
        }
                }
                return sb.toString();
            }
        }
    }
}