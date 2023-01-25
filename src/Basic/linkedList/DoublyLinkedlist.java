package linkedList;

import java.util.Scanner;


public class DoublyLinkedlist{
    dNode head;
    public  void  InsertLast(int data){
        dNode newNode = new dNode();
        newNode.data =data;
        newNode.next=null;
        if(head == null) {
            head = newNode;
            newNode.prev =null;
        }
        else {
            dNode n =head;
            while(n.next != null){
                n = n.next;
            }
            n.next= newNode;
            newNode.prev =n;
            n= n.next;
            n.next = null;
        }

    }
    public  void  InsertFirst(int data){
        dNode newNode = new dNode();
        newNode.data =data;
        newNode.next=null;
        if(head == null){
            head = newNode;
            newNode.prev = null;
        }
        else {
            dNode n =head;
            newNode.next =head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void InsertDesired(int index, int data){
        dNode newNode = new dNode();
        newNode.data =data;
        newNode.next=null;
        if(index == 0){
            InsertFirst(data);
        }
        else {
            dNode n = head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            newNode.next = n.next;
            newNode.prev = n ;
            n.next =newNode;
            newNode.next.prev =newNode;
        }

    }
    public void deleteFirst(){
        if(head == null){
            System.out.println("dlist is empty");
        }
        else{
            dNode n = head;
            System.out.println();
            System.out.println(head.data+" is deleted");
            head = n.next;
            head.prev = null;
        }
    }
    public  void  deleteLast(){
        dNode n = head;
        dNode n1 = null;
        if(head == null){
            System.out.println("dlist is empty");
        }
        else {
            while (n.next != null){
                n1 = n;
                n = n.next;
            }
            System.out.println();
            System.out.println(n1.next.data + " is deleted");
            n1.next= null;
        }
    }
    public void deleteDesired(int index){

        if(index == 0){
            head = head.next;
            head.next.prev= null;
        }
        else{
            dNode n = head;
            dNode n1 = null;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            n1.next.prev = n;
            System.out.println();
            System.out.println(n1.data+" is deleted");
        }
    }
    public void display(){
        dNode n = head;
        dNode last = null;
        if(head == null)
            System.out.println("dlist is empty");
        else {
            while (n != null){
                System.out.print(n.data +" ");
                last = n;
                n = n.next;
            }
        }
        System.out.println();
        System.out.println("Print in reverse");
        while (last != null){
            System.out.print(last.data +" ");
            last =last.prev;
        }
        System.out.println();
    }

    private class  dNode{
       private int data;
       private dNode next;
       private dNode prev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedlist dlist = new DoublyLinkedlist();

        int choice;
        String ch;
        System.out.println(" Enter  \n\t 1 -- InsertFirst \n\t 2 -- InsertLast  \n\t 3 -- InsertDesired" +
                "\n\t 4 -- DeleteFirst \n\t 5 -- DeleteLast \n\t 6 -- DeleteDesired \n\t 7 -- Display  ");

        do {
            //System.out.println();
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the Number want to Insert At First");
                    dlist.InsertFirst(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter the Number want to Insert At Last");
                    dlist.InsertLast(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter the Index of any Location and the Number want to Insert At that location ");
                    dlist.InsertDesired(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    dlist.deleteFirst();
                    break;
                case 5:
                    dlist.deleteLast();
                    break;
                case 6:
                    System.out.println("Enter the any Location you want to delete");
                    dlist.deleteDesired(sc.nextInt());
                    break;
                case 7:
                    dlist.display();
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

