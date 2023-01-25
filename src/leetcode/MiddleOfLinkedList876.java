package leetcode;

/**
 * @author KUCHAY_AASHIQ
 *		876. Middle of the Linked List
		Given the head of a singly linked list, return the middle node of the linked list.		
		If there are two middle nodes, return the second middle node.
	
		Example 1:
	
		Input: head = [1,2,3,4,5]
		Output: [3,4,5]
		Explanation: The middle node of the list is node 3.
		Example 2:
	
		Input: head = [1,2,3,4,5,6]
		Output: [4,5,6]
		Explanation: Since the list has two middle nodes with values 3 and 4,
		 we return the second one.
	
		Constraints:
		
		The number of nodes in the list is in the range [1, 100].
		1 <= Node.val <= 100
 */
public class MiddleOfLinkedList876 {
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
        MiddleOfLinkedList876 ad1 = new MiddleOfLinkedList876();
        ad1.InsertLast(1);
        ad1.InsertLast(2);       
        ad1.InsertLast(3);
        ad1.InsertLast(4);
        ad1.InsertLast(5);
        ad1.InsertLast(6);   
        ListNode ans = ad1.middleNode();
        ad1.show(ans);
    }
    public ListNode middleNode() {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
