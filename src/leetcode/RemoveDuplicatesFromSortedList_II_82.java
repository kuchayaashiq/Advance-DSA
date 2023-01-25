package leetcode;

/*
 * 		Question : 82. Remove Duplicates from Sorted List II
		Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

		Example 1:

		Input: head = [1,2,3,3,4,4,5]
		Output: [1,2,5]
		Example 2:
	
		Input: head = [1,1,1,2,3]
		Output: [2,3]

		Constraints:
		
		The number of nodes in the list is in the range [0, 300].
		-100 <= Node.val <= 100
		The list is guaranteed to be sorted in ascending order.
*/
public class RemoveDuplicatesFromSortedList_II_82 {
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
        RemoveDuplicatesFromSortedList_II_82 ad1 = new RemoveDuplicatesFromSortedList_II_82();
        ad1.InsertLast(1);
        ad1.InsertLast(2);
        ad1.InsertLast(2);
        ad1.InsertLast(2);
        ad1.InsertLast(2);
        ad1.InsertLast(3);
        ad1.InsertLast(4);
        ad1.InsertLast(4);
        ad1.InsertLast(5);
        ListNode ans = ad1.deleteDuplicates_II(ad1.head);
        ad1.show(ans);
    }
    public ListNode deleteDuplicates_II(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode i = head;
        ListNode j = head;
        ListNode answerhead = null;
        ListNode answertail = null;
        while(i != null){
        	int freq = 0;
            while(j != null && j.val == i.val){
                freq++;
            	j = j.next;
            }
        	if(freq == 1){
                // i will pointing to the unique value 
                if(answerhead == null && answertail == null)
                {
                    answerhead = i;
                    answertail = i;
                }
                else
                {
                    answertail.next = i;
                    answertail = i;
                }
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
