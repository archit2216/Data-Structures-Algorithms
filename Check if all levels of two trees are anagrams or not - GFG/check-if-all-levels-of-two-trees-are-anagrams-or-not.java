//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
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
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
        }
        if(node1.data!=node2.data){
            return false;
        }
        
        Queue<Node> q1=new ArrayDeque<>();
        Queue<Node> q2=new ArrayDeque<>();
        
        q1.add(node1);
        q2.add(node2);
        
        while(q1.size()>0 && q2.size()>0){
            Node rem1=q1.remove();
            Node rem2=q2.remove();
            
            int s1=q1.size();
            int s2=q2.size();
            if(s1!=s2){
                return false;
            }
            ArrayList<Integer> al1=new ArrayList<>();
            ArrayList<Integer> al2=new ArrayList<>();
            while(s1>0 && s2>0){
                if(rem1.left!=null){
                    al1.add(rem1.left.data);
                    q1.add(rem1.left);
                }
                if(rem1.right!=null){
                    al1.add(rem1.right.data);
                    q1.add(rem1.right);
                }
                if(rem2.left!=null){
                    al2.add(rem2.left.data);
                    q2.add(rem2.left);
                }
                if(rem2.right!=null){
                    al2.add(rem2.right.data);
                    q2.add(rem2.right);
                }
                s1--;
                s2--;
            }
            Collections.sort(al1);
            Collections.sort(al2);
            if(!al1.equals(al2)){
                return false;
            }
        }
        
        return true;
        // code here
    }
}  
