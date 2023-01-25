package leetcode;

/**
 * @author KUCHAY_AASHIQ
 *		You are given the heads of two sorted linked lists list1 and list2.
		Merge the two lists in a one sorted list. The list should be made by splicing together 
		the nodes of the first two lists.	
		Return the head of the merged linked list.

		Example 1:

		Input: list1 = [1,2,4], list2 = [1,3,4]
		Output: [1,1,2,3,4,4]
		Example 2:
		
		Input: list1 = [], list2 = []
		Output: []
		Example 3:
		
		Input: list1 = [], list2 = [0]
		Output: [0]

		Constraints:
		
		The number of nodes in both lists is in the range [0, 50].
		-100 <= Node.val <= 100
		Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoLinkedLists21 {
		
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
        MergeTwoLinkedLists21 ad1 = new MergeTwoLinkedLists21();
        MergeTwoLinkedLists21 ad2 = new MergeTwoLinkedLists21();
        MergeTwoLinkedLists21 ad3 = new MergeTwoLinkedLists21();
        ad1.InsertLast(2);
        ad1.InsertLast(4);
        ad1.InsertLast(9);
        ad2.InsertLast(4);
        ad2.InsertLast(5);
        ad2.InsertLast(6);   
        ad2.InsertLast(9);
        ListNode ans = ad1.mergeTwoLists(ad2.head);
        ad3.show(ans);
    }
	 public ListNode mergeTwoLists(ListNode list2) {
		 ListNode list1 = head;        
		 if(list1 == null){
	            return list2;
	        }
	        if(list2 == null){
	            return list1;
	        }
	        if(list1 == null && list2 == null){
	            return null;
	        }
	       ListNode ansHead = null;
	        ListNode ansTail = null;
	 
	    ListNode l1=list1;
	    ListNode l2=list2;
	    while(l1!=null && l2!=null){
	        if(l1.val < l2.val){
	            if(ansHead == null && ansTail == null){
	                ansHead = l1;
	                ansTail = l1;
	            }
	            else{
	                ansTail.next = l1;
	                ansTail = l1;
	            }
	            l1= l1.next;
	        }
	        else{
	            if(ansHead == null && ansTail == null){
	                ansHead = l2;
	                ansTail = l2;
	            }
	            else{
	                ansTail.next = l2;
	                ansTail = l2;
	            }
	            l2= l2.next;
	        }
	        
	    }
	 
	    if(l1!=null){
	        ansTail.next = l1;
	    }
	 
	    if(l2!=null){
	        ansTail.next = l2;
	    }
	 
	    return ansHead;
	    }
}
