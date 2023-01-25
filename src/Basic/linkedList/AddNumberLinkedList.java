package linkedList;

import java.util.Scanner;
class  Nodee{
    int data;
    Nodee next;
}
class  linkedLisst{
    Nodee head;
    public void insert( int data){
        Nodee node = new Nodee();
        node.data = data;
        node.next = null;
        if(head == null){
            head = node;
        }
        else{
            Nodee n = head;
            while (n.next != null){
                n= n.next;
            }
            n.next =node;
        }
    }
    public  void display(){
        Nodee node =head;
        while (node.next != null){
            System.out.print(node.data+ " ");
            node= node.next;
        }
        System.out.print(node.data+ " ");
    }
}
public class AddNumberLinkedList {
    public static void main(String[] args) {
        linkedLisst list = new linkedLisst();
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();
        int arr[] = new int[100];
        int i =0,rem;
        while (num>0){
            rem = num%10;
            arr[i] = rem;
            num /= 10;
            i++;
        }
        for (int j = i-1; j >=0; j--) {
            list.insert(arr[j]);
        }
        list.display();
    }
}
