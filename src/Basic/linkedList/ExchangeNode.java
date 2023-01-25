package linkedList;

public class ExchangeNode {
    private class Node {
        private int data;
        private Node next;
    }
    Node head;
    public Node insertLast(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        Node tail = null;
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            Node n = head;
            while (n.next != null){
                n= n.next;
            }
            n.next =node;
            tail = node;
        }
        return tail;
    }
    public Node exchangeNode(Node tail){
        Node n = head;
        Node temp = head;
        Node r = n;
        while (n.next != null){
            r =n;
            n = n.next;
        }
        r.next = head;
        head = tail;
        head.next = temp.next;
        r = r.next;
        r.next =null;
        tail = r;
        return head;

    }
    public  void show( Node h){
        Node node =h;
        while (node!= null){
            System.out.print(node.data+ " ");
            node= node.next;
        }
    }

    public static void main(String[] args) {
        ExchangeNode cl = new ExchangeNode();
        Node ans;
        ans = cl.insertLast(12);
        ans = cl.insertLast(14);
        ans = cl.insertLast(17);
        ans = cl.insertLast(24);
        ans = cl.insertLast(27);
        ans = cl.insertLast(30);
        Node h1 = cl.exchangeNode(ans);
        cl.show(h1);

    }
}
