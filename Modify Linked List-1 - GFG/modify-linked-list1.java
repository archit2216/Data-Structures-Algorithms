//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static int length(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    public static Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
    public static Node modifyTheList(Node head)
    {
        int len=length(head);
        
        int count=0;
        Node temp=head;
        while(count<(len-1)/2){
            temp=temp.next;
            count++;
        }
        
        Node secHead=temp.next;
        temp.next=null;
        secHead=reverse(secHead);
        
        temp=head;
        Node secTemp=secHead;
        while(secTemp!=null){
            int tempData=temp.data;
            temp.data=secTemp.data-temp.data;
            secTemp.data=tempData;
            temp=temp.next;
            secTemp=secTemp.next;
        }
        
        secHead=reverse(secHead);
        temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=secHead;
        return head;
    }
}