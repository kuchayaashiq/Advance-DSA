package linkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;
}

class LinkedList {
    Node head;
    public void insertLast( int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if(head == null){
            head = node;
        }
        else{
            Node n = head;
            while (n.next != null){
                n= n.next;
            }
            n.next =node;
        }
    }
    public void insertAtStart( int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if(head == null){
            head = node;
        }
        else{
            node.next= head;
            head =node;
        }
    }
    public void insertAt(int index, int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if(index == 0){
            insertAtStart(data);
        }
        else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;

            }
            node.next = n.next;
            n.next = node;
        }

    }
    public void deleteAt(int index){
        if(index==0){
            head = head.next;
        }
        else{
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            System.out.println();
            System.out.println(n1.data+" is deleted");
        }
    }
    public void deleteAtStart(){
        Node n = head;
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            System.out.println();
            System.out.println(head.data+" is deleted");
            head = n.next;
        }
    }
    public void deleteAtLast(){
        Node n = head;
        Node n1 = null;
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            while (n.next!=null) {
                n1= n;
                n = n.next;
            }
            System.out.println();
            System.out.println(n1.next.data + " is deleted");
            n1.next=null;
        }
    }

    public  void show(){
        Node node =head;
        while (node!= null){
            System.out.print(node.data+ " ");
            node= node.next;
        }
    }
}
public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int choice;
        String ch;
        System.out.println(" Enter  \n\t 1 -- InsertFirst \n\t 2 -- InsertLast  \n\t 3 -- InsertAt" +
                "\n\t 4 -- DeleteFirst \n\t 5 -- DeleteLast \n\t 6 -- DeleteAt \n\t 7 -- Display  ");

        do {
            //System.out.println();
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the Number want to Insert At First");
                    list.insertAtStart(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter the Number want to Insert At Last");
                    list.insertLast(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter the Index of any Location and the Number want to Insert At that location ");
                    list.insertAt(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    list.deleteAtStart();
                    break;
                case 5:
                    list.deleteAtLast();
                    break;
                case 6:
                    System.out.println("Enter the any Location you want to delete");
                    list.deleteAt(sc.nextInt());
                    break;
                case 7:
                    list.show();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            System.out.println();
            System.out.println("Do you want to Cont1inue  y/n ?");
            ch = sc.next();
        }
        while (ch.equals("y") || ch.equals("Y"));
    }
}
