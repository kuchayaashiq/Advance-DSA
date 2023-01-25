package linkedList;

import java.util.Scanner;

public class MergeTwoLists {
    private class Node{
        private int data;
        private Node next;
    }
    Node head;
    public void InsertLast(int data){
        Node newNode = new Node();
        newNode.data =data;
        newNode.next = null;
        if(head == null){
            head = newNode;
        }
        else{
            Node n = head;
            while (n.next !=null){
                n = n.next;
            }
            n.next = newNode;
        }
    }
    public static void print(Node h1){
        Node n = h1;
        while (n != null){
            System.out.print(n.data +" ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        MergeTwoLists list1 = new MergeTwoLists();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list1.InsertLast(sc.nextInt());
        }
        MergeTwoLists list2 = new MergeTwoLists();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            list2.InsertLast(sc.nextInt());
        }

       //MergeTwoLists ans = mergeTwoLists(list1.head,list2.head);
        //print(ans.head);
        //Merge Two Linked lists using link
        MergeTwoLists list3 = new MergeTwoLists();
        Node res = list3.mergeTwolist(list1.head,list2.head);
        print(res);
    }

    private Node mergeTwolist(Node head1, Node head2) {
        Node n1 = head1;
        Node n2 = head2;
        Node res = new Node();
        Node n3 = res;
        while (n1 != null && n2 != null){
            if(n1.data < n2.data){
                n3.next = n1;
                n1 = n1.next;

            }
            else {
                n3.next = n2;
                n2 = n2.next;
            }
            n3 = n3.next;
        }
        while (n1 != null){
            n3.next = n1;
            n1 = n1.next;
            n3 = n3.next;
        }
        while (n2 != null){
            n3.next = n2;
            n2 = n2.next;
            n3 = n3.next;
        }
        return res.next;

    }

    private static MergeTwoLists mergeTwoLists(Node head1, Node head2) {
        Node n1 =head1;
        Node n2 = head2;
        MergeTwoLists result =  new MergeTwoLists();
        while(n1 != null & n2 != null){
            if(n1.data < n2.data){
                result.InsertLast(n1.data);
                n1 = n1.next;
            }
            else{
                result.InsertLast(n2.data);
                n2 = n2.next;
            }
        }
        while (n1 != null){
            result.InsertLast(n1.data);
            n1 = n1.next;
        }
        while (n2 != null){
            result.InsertLast(n2.data);
            n2 = n2.next;
        }
        return result;
    }
}
