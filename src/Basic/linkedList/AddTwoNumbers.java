package linkedList;


import java.util.Scanner;

public class AddTwoNumbers {
    private class ListNode{
        private int val;
        private ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }
        ListNode head;
        public void InsertLast( int val){
            ListNode node = new ListNode();
            node.val = val;
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
    public  void show(ListNode head){
        ListNode node =head;
        while (node!= null){
            System.out.print(node.val+ " ");
            node= node.next;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddTwoNumbers ad1 = new AddTwoNumbers();
        AddTwoNumbers ad2 = new AddTwoNumbers();
        AddTwoNumbers ad3 = new AddTwoNumbers();
        ad1.InsertLast(2);
        ad1.InsertLast(4);
        ad1.InsertLast(9);
        ad2.InsertLast(5);
        ad2.InsertLast(6);
        ad2.InsertLast(4);
        ad2.InsertLast(9);
        ListNode ans = ad1.AddNumbers(ad2.head);
        ad3.show(ans);
    }

    private ListNode AddNumbers(ListNode head1) {
            ListNode n1 = head, n2 = head1;
            int carry = 0;
            ListNode first = null, last = null;
            while(n1 != null || n2 != null || carry!=0){
                int sum = 0;
                if(n1 !=null){
                    sum = sum+n1.val;
                    n1= n1.next;
                }
                if(n2 !=null){
                    sum = sum+n2.val;
                    n2= n2.next;
                }
                sum +=carry;
                carry = sum/10;
                if(sum >=10){
                    if(first == null){
                        last = new ListNode(sum%10);
                        first = last;
                    }
                    else{
                        last.next = new ListNode(sum%10);
                        last = last.next;
                    }
                }
                else {
                    if(first == null){
                        last = new ListNode(sum%10);
                        first = last;
                    }
                    else{
                        last.next = new ListNode(sum%10);
                        last = last.next;
                    }
                }
            }
            return first;
    }
}
