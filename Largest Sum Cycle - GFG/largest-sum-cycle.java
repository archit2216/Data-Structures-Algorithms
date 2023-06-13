//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    List<Integer> temp=new ArrayList<>();
    public long dfs(int src,int par,ArrayList<ArrayList<Integer>> graph,int[] vis,int[] parent){
        vis[src]=1;
        parent[src]=par;
        temp.add(src);
        
        for(Integer nbr:graph.get(src)){
            if(vis[nbr]==0){
                long smallAns=dfs(nbr,src,graph,vis,parent);
                if(smallAns!=-1){
                    return smallAns;
                }
            }else if(vis[nbr]==1){
                long sum=nbr;
                while(src!=nbr){
                    sum+=src;
                    src=parent[src];
                }
                if(src==nbr){
                    return sum;
                }
                return -1;
            }
        }
        return -1;
    }
    public long largesSumCycle(int n, int edges[]){
        long max=-1;
        int[] vis=new int[n];
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int[] parent=new int[n];
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            if(edges[i]!=-1){
                graph.get(i).add(edges[i]);
            }
        }
        
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                max=Math.max(max,dfs(i,-1,graph,vis,parent));
                for(int j:temp){
                    vis[j]=2;
                }
                temp=new ArrayList<>();
            }
        }
        return max;
    }
}