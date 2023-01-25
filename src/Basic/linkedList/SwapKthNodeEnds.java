package linkedList;

import java.util.Scanner;

/*
   Given a singly linked list of size N, and an integer K. You need to swap the Kth node from beginning and
    Kth node from end in linked list.
    Note: You need to swap the nodes through the links and not changing the content of the nodes.
    INPUT :
         5 3
        1 2 3 4 5
    OUTPUT :


    */
public class SwapKthNodeEnds {
    private class ListNode{
        private int data;
        private ListNode next;
    }
    ListNode head;
    public void insertLast( int data){
        ListNode newNode = new ListNode();
        newNode.data = data;
        newNode.next = null;
        if(head == null){
            head = newNode;
        }
        else{
            ListNode n = head;
            while (n.next != null){
                n= n.next;
            }
            n.next =newNode;
        }
    }
    public  void show(){
        ListNode node =head;
        while (node!= null){
            System.out.print(node.data+ " ");
            node= node.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SwapKthNodeEnds list = new SwapKthNodeEnds();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        list.show();
        list.swapNodes(list.head, n, k);

        list.show();
    }

    private ListNode swapNodes(ListNode head, int n, int k) {
        if(k>n){
            System.out.println("Swaping is Not Possible");
            return head;
        }
        // if Kth node is from both the ends
        if(k ==(n-k+1))
            return head;
        ListNode start = head, sPrev = null;
        int x=k;
        while(x>1){
            sPrev = start;
            start = start.next;
            x--;
        }
        ListNode end = head, ePrev = null;
        x= n-k+1;
        while(x>1) {
            ePrev = end;
            end = end.next;
            x--;
        }
        if (sPrev != null)
            sPrev.next = end;

        if (ePrev != null)
            ePrev.next = start;

        ListNode temp = start.next;
        start.next = end;
        end = temp;

        if (k==1)
            head = end;
        if (k == n)
            head = start;

        return head;
    }
}
