package leetcode;


/**
 * @author KUCHAY_AASHIQ
 *		Given the head of a linked list and an integer val, remove all the nodes of the 
 *      linked list that has Node.val == val, and return the new head.

		Example 1:

		Input: head = [1,2,6,3,4,5,6], val = 6
		Output: [1,2,3,4,5]
		Example 2:
		
		Input: head = [], val = 1
		Output: []
		Example 3:
		
		Input: head = [7,7,7,7], val = 7
		Output: []
 
 */
public class RemoveLinkedListElements203 {
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
    	RemoveLinkedListElements203 ad1 = new RemoveLinkedListElements203();
    	RemoveLinkedListElements203 ad2 = new RemoveLinkedListElements203();
        
        ad1.InsertLast(1);
        ad1.InsertLast(2);
        ad1.InsertLast(6);
        ad1.InsertLast(3);
        ad1.InsertLast(4);
        ad1.InsertLast(5);
        ad1.InsertLast(6);
        int val = 6;
        ListNode ans = ad1.removeElements(ad1.head, val);
        ad2.show(ans);
    }
	public ListNode removeElements(ListNode head, int val) {
        if(head == null ){
            return head;
        }
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode prev = temp;
        ListNode curr = head;
        
        while(curr != null){
           if(curr.val == val){
               prev.next = curr.next;
               curr = curr.next;
           }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return temp.next;
    }
}
