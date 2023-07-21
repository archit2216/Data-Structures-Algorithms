//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    static Node th;
    static Node tt;
    public static int length(Node node){
        int count=0;
        while(node!=null){
            node=node.next;
            count++;
        }
        return count;
    }
    public static void addFirst(Node node){
        if(th==null){
            th=node;
            tt=node;
        }else{
            node.next=th;
            th=node;
        }
    }
    public static Node reverse(Node node, int k)
    {
        th=null;
        tt=null;
        
        Node oh=null;
        Node ot=null;
        Node temp=node;
        int len=length(node);
        
        while(len-k>=0){
            int c=0;
            while(c<k){
                Node forw=temp.next;
                temp.next=null;
                addFirst(temp);
                temp=forw;
                c++;
            }
            if(oh==null){
                oh=th;
                ot=tt;
            }else{
                ot.next=th;
                ot=tt;
            }
            th=null;
            tt=null;
            len-=k;
        }
        
        while(temp!=null){
            Node forw=temp.next;
            temp.next=null;
            addFirst(temp);
            temp=forw;
        }
        if(oh==null){
            oh=th;
            ot=tt;
        }else{
            ot.next=th;
            ot=tt;
        }
        return oh;
        
        //Your code here
    }
}

