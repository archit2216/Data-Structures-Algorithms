//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
    static HashSet<Integer> hs;
    public static Node MergeLists(Node l1,Node l2){
        if(l1==null && l2==null){
            return l2;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        
        Node t1=l1;
        Node t2=l2;
        
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(t1!=null && t2!=null){
            if(t1.data<t2.data){
                temp.next=t1;
                t1=t1.next;
            }else{
                temp.next=t2;
                t2=t2.next;
            }
            temp=temp.next;
        }
        
        while(t1!=null){
            temp.next=t1;
            t1=t1.next;
            temp=temp.next;
        }
        while(t2!=null){
            temp.next=t2;
            t2=t2.next;
            temp=temp.next;
        }
        temp.next=null;
        return dummy.next;
    }
    public static Node MergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node secHead=slow.next;
        slow.next=null;
        
        Node l1=MergeSort(head);
        Node l2=MergeSort(secHead);
        
        return MergeLists(l1,l2);
        
    }
	public static Node findUnion(Node head1,Node head2)
	{
	    
	    Node h1=MergeSort(head1);
	    Node h2=MergeSort(head2);
	    
	    hs=new HashSet<>();
	    if(h1==null && h2==null){
            return h2;
        }
        else if(h1==null){
            return h2;
        }
        else if(h2==null){
            return h1;
        }
        
        Node t1=h1;
        Node t2=h2;
        
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(t1!=null && t2!=null){
            boolean flag=false;
            if(t1.data<t2.data){
                if(!hs.contains(t1.data)){
                    temp.next=t1;
                    hs.add(t1.data);
                    flag=true;
                }
                t1=t1.next;
            }else{
                if(!hs.contains(t2.data)){
                    temp.next=t2;
                    hs.add(t2.data);
                    flag=true;
                }
                t2=t2.next;
            }
            if(flag){
                temp=temp.next;
            }
        }
        
        while(t1!=null){
            boolean flag=false;
            if(!hs.contains(t1.data)){
                temp.next=t1;
                hs.add(t1.data);
                flag=true;
            }
            t1=t1.next;
            if(flag){
                temp=temp.next;
            }
        }
        while(t2!=null){
            boolean flag=false;
            if(!hs.contains(t2.data)){
                temp.next=t2;
                hs.add(t2.data);
                flag=true;
            }
            t2=t2.next;
            if(flag){
                temp=temp.next;
            }
        }
        temp.next=null;
        return dummy.next;
	    //Add your code here.
	}
}