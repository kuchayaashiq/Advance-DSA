package linkedList;

import java.util.Scanner;

public class MergeSortOnLinkedList {
    private class ListNode {
        private int data;
        private ListNode next;
    }
    ListNode head;
    public void insertLast(int data){
        ListNode node = new ListNode();
        node.data = data;
        node.next = null;
        if(head == null){
            head = node;
        }
        else{
            ListNode n = head;
            while (n.next != null){
                n= n.next;
            }
            n.next =node;
        }
    }
    public  ListNode midNode(ListNode head){
        if(head == null || head.next == null)
            return  head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next  != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return  slow;

    }

    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null)
            return h2;
        else if (h2 == null)
            return h1;
        ListNode ans = null;
        ListNode n1 = h1;
        ListNode n2 = h2;
        ListNode res = new ListNode();
        ListNode n3 = res;
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

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next ==null)
            return  head;
        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(nHead);
        head = merge(l1,l2);
        return head;
    }
    public  void show( ListNode h){
        ListNode node =h;
        while (node!= null){
            System.out.print(node.data+ " ");
            node= node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSortOnLinkedList mlist = new MergeSortOnLinkedList();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mlist.insertLast(sc.nextInt());
        }
        ListNode ans = mlist.mergeSort(mlist.head);
        mlist.show(ans);

    }
}
