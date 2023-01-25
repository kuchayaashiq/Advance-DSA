package leetcode;

/**
 * @author KUCHAY_AASHIQ
 *		445. Add Two Numbers II
		You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
		
		You may assume the two numbers do not contain any leading zero, except the number 0 itself.
		
		Example 1:

		Input: l1 = [7,2,4,3], l2 = [5,6,4]
		Output: [7,8,0,7]
		Example 2:
		
		Input: l1 = [2,4,3], l2 = [5,6,4]
		Output: [8,0,7]
		Example 3:
		
		Input: l1 = [0], l2 = [0]
		Output: [0]
		
		Constraints:
		
		The number of nodes in each linked list is in the range [1, 100].
		0 <= Node.val <= 9
		It is guaranteed that the list represents a number that does not have leading zeros.
		 
 */
public class AddTwoNumbersII445 {
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
        AddTwoNumbersII445 ad1 = new AddTwoNumbersII445();
        AddTwoNumbersII445 ad2 = new AddTwoNumbersII445();
        AddTwoNumbersII445 ad3 = new AddTwoNumbersII445();
        ad1.InsertLast(7);
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
        ListNode n1 = reverse(l1);
            ListNode n2 = reverse(l2);
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
            ListNode ans = reverse(first);
           return ans;
   }
    public ListNode reverse(ListNode head1){
       ListNode current = head1;
       ListNode prev = null;
       ListNode next = null;
       while (current != null){
           next = current.next;
           current.next = prev;
           prev = current;
           current= next;
       }
       return prev;
   }
}
