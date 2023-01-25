package leetcode;

import java.util.Scanner;


/**
 * @author KUCHAY_AASHIQ
 *		Given the head of a sorted linked list, delete all duplicates such that 
 *       each element appears only once. Return the linked list sorted as well.

		Example 1:

		Input: head = [1,1,2]
		Output: [1,2]
		Example 2:

		Input: head = [1,1,2,3,3]
		Output: [1,2,3]

		Constraints:
		
		The number of nodes in the list is in the range [0, 300].
		-100 <= Node.val <= 100
		The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedList_83 {
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
	        RemoveDuplicatesFromSortedList_83 ad1 = new RemoveDuplicatesFromSortedList_83();
	        ad1.InsertLast(1);
	        ad1.InsertLast(1);
	        ad1.InsertLast(2);
	        ad1.InsertLast(2);
	        ad1.InsertLast(2);
	        ad1.InsertLast(3);
	        ad1.InsertLast(4);
	        ad1.InsertLast(4);
	        ListNode ans = ad1.deleteDuplicates(ad1.head);
	        ad1.show(ans);
	    }
	    public ListNode deleteDuplicates(ListNode head) {
	        if(head == null){
	            return head;
	        }
	        ListNode i = head;
	        ListNode j = head;
	        ListNode answerhead = null;
	        ListNode answertail = null;
	        while(i != null){
	            while(j != null && j.val == i.val){
	                j = j.next;
	            }
	            if(answerhead == null && answertail == null){
	                answerhead = i;
	                answertail = i;
	                
	            }
	            else{
	                answertail.next = i;
	                answertail = i;
	                
	            }
	            i = j;
	            
	        }
	        if(answertail != null)
	        {
	            answertail.next = null;
	        }

	        return answerhead;
	    }
}
