package leetcode;


/**
 * @author KUCHAY_AASHIQ
 *		19. Remove Nth Node From End of List
		Given the head of a linked list, remove the nth node from the end of the list and 
		return its head.

		Example 1:
	
		Input: head = [1,2,3,4,5], n = 2
		Output: [1,2,3,5]
		Example 2:
		
		Input: head = [1], n = 1
		Output: []
		Example 3:
		
		Input: head = [1,2], n = 1
		Output: [1]
 */
public class RemoveNthNodeFromEnd19 {
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
            ListNode node = new ListNode(val);
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
        RemoveNthNodeFromEnd19 ad1 = new RemoveNthNodeFromEnd19();
        RemoveNthNodeFromEnd19 ad3 = new RemoveNthNodeFromEnd19();
        
        ad1.InsertLast(1);
        ad1.InsertLast(2);
        ad1.InsertLast(3);
        ad1.InsertLast(4);
        ad1.InsertLast(5);
        ad1.InsertLast(6);
        int n = 2;
        ListNode ans = ad1.removeNthFromEnd(ad1.head, n);
        ad3.show(ans);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp  = new ListNode();
        temp.next = head;
        ListNode fast =head;
        ListNode slow = temp;
        for(int i=1; i<n; i++) {
              fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;           
        }
        slow.next = slow.next.next;
        return head;
    }
}
