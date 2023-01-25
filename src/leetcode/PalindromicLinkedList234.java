/**
 * 
 */
package leetcode;



/**
 * @author KUCHAY_AASHIQ
 *		234. Palindrome Linked List
		Given the head of a singly linked list, return true if it is a palindrome or false 
		otherwise.
		
		Example 1:

		Input: head = [1,2,2,1]
		Output: true
		Example 2:
	
		Input: head = [1,2]
		Output: false

		Constraints:
		
		The number of nodes in the list is in the range [1, 105].
		0 <= Node.val <= 9
 */
public class PalindromicLinkedList234 {
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
    	PalindromicLinkedList234 ad1 = new PalindromicLinkedList234();
        ad1.InsertLast(1);
        ad1.InsertLast(2);       
        ad1.InsertLast(2);
        ad1.InsertLast(1);   
        boolean ans = ad1.isPalindrome(ad1.head);
        System.out.println(ans);
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode mid = MiddleNode(head);
        ListNode last = reverse(mid);
        ListNode current = head;
        while(last != null){
            if(last.val != current.val)
                return false;
            last= last.next;
            current= current.next;
        }
        return true;
        
    }
    public ListNode MiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
       while(fast != null && fast.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode current = head, prev = null, next = null;
        while(current != null){
            next = current.next;
            current.next = prev; 
            prev =current;
            current = next;
        }
        return prev;
    }
}
