//{ Driver Code Starts
//Initial template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Solution ob = new Solution();
            if((turn = ob.NumberOfTurns(root, nd1, nd2)) != 0)
              System.out.println(turn);
            else
              System.out.println("-1");
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{
    static int c1;
    static int c2;
    static void findTurns(Node root,int first,int second,int dir,int turns){
        if(root==null){
            return;
        }
        if(root.data==first || root.data==second){
            if(root.data==first){
                c1=turns;
            }
            if(root.data==second){
                c2=turns;
            }
            return;
        }
        
        if(dir==0){
            findTurns(root.left,first,second,0,turns);
            findTurns(root.right,first,second,1,turns+1);
        }else{
            findTurns(root.left,first,second,0,turns+1);
            findTurns(root.right,first,second,1,turns);
        }
    }
    static Node LowestCommon(Node root,int first,int second){
        if(root==null){
            return null;
        }
        if(root.data==first){
            return root;
        }
        if(root.data==second){
            return root;
        }
        
        Node ls=LowestCommon(root.left,first,second);
        Node rs=LowestCommon(root.right,first,second);
        if(ls!=null && rs!=null){
            return root;
        }
        if(ls!=null && rs==null){
            return ls;
        }
        if(ls==null && rs!=null){
            return rs;
        }
        return null;
    }
    static int NumberOfTurns(Node root, int first, int second)
    {
        Node lca=LowestCommon(root,first,second);
        c1=0;
        c2=0;
        findTurns(lca.left,first,second,0,0);
        findTurns(lca.right,first,second,1,0);
        
        if(lca.data==first || lca.data==second){
            return c1+c2;
        }else{
            return c1+c2+1;
        }
        
        //your code here
    }
}