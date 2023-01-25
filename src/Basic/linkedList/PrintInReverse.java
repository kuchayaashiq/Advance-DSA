package linkedList;

import java.util.Scanner;

class  Noode{
    int data;
    Noode next;
}
class  linkedLists{
    Noode head;
    public void insert( int data){
        Noode node = new Noode();
        node.data = data;
        node.next = null;
        if(head == null){
            head = node;
        }
        else{
            Noode n = head;
            while (n.next != null){
                n= n.next;
            }
            n.next =node;
        }
    }
    public void reverse(){
        Noode current = head;
        Noode prev = null;
        Noode next = null;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current= next;
        }
        head = prev;
    }
    public  void display(){
        System.out.println();
        Noode node =head;
        while (node != null){
            System.out.print(node.data+ " ");
            node= node.next;
        }

    }
}
public class PrintInReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        linkedLists lists = new linkedLists();
        for (int i = 0; i < n; i++) {
            lists.insert(sc.nextInt());
        }
        //lists.display();
        lists.reverse();
        lists.display();
    }
}
