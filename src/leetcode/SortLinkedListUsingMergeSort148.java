package leetcode;


public class SortLinkedListUsingMergeSort148 {
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
    	SortLinkedListUsingMergeSort148 ad1 = new SortLinkedListUsingMergeSort148();
    	SortLinkedListUsingMergeSort148 ad2 = new SortLinkedListUsingMergeSort148();
        
    	ad1.InsertLast(5);
    	ad1.InsertLast(3);
        ad1.InsertLast(2);
        ad1.InsertLast(6);       
        ad1.InsertLast(4);
        ad1.InsertLast(1);
        ad1.InsertLast(6);
        ListNode ans = ad1.MergeSort(ad1.head);
        ad2.show(ans);
    }
    
    public ListNode MergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // middle Element 
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode firstLinkedList = MergeSort(head);
        ListNode secondLinkedList = MergeSort(slow);
        
        return mergeTwoLists(firstLinkedList, secondLinkedList);
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
