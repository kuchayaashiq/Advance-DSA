package leetcode;

/**
 * @author KUCHAY_AASHIQ
 *		You are given two non-empty linked lists representing two non-negative integers. 
		The digits are stored in reverse order, and each of their nodes contains a single digit.
		 Add the two numbers and return the sum as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

		Example 1:

		Input: l1 = [2,4,3], l2 = [5,6,4]
		Output: [7,0,8]
		Explanation: 342 + 465 = 807.
		Example 2:
		
		Input: l1 = [0], l2 = [0]
		Output: [0]
		Example 3:
		
		Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
		Output: [8,9,9,9,0,0,0,1]

		Constraints:
		
		The number of nodes in each linked list is in the range [1, 100].
		0 <= Node.val <= 9
		It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbersInLinkedList_2 {
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
        AddTwoNumbersInLinkedList_2 ad1 = new AddTwoNumbersInLinkedList_2();
        AddTwoNumbersInLinkedList_2 ad2 = new AddTwoNumbersInLinkedList_2();
        AddTwoNumbersInLinkedList_2 ad3 = new AddTwoNumbersInLinkedList_2();
        
        ad1.InsertLast(2);
        ad1.InsertLast(4);
        ad1.InsertLast(3);
        
        ad2.InsertLast(5);
        ad2.InsertLast(6);
        ad2.InsertLast(4);
        ListNode ans = ad1.addTwoNumbers(ad1.head, ad2.head);
        ad3.show(ans);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode n1 = l1, n2 = l2;
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
