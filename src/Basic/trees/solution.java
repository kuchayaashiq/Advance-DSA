package trees;

import java.util.Scanner;

 class Node{

    int data;
    Node left;
    Node right;

    Node(int data){

        this.data = data;
        this.left  = null;
        this.right = null;
    }
}
class Tree{

    Node root;

    void inOrder(Node currNode){

        if(currNode==null){
            return;
        }

        inOrder(currNode.left);
        System.out.print(currNode.data+" ");
        inOrder(currNode.right);
    }
    void preOrder(Node currNode){

        if(currNode==null){
            return;
        }
        System.out.print(currNode.data+" ");
        preOrder(currNode.left);

        preOrder(currNode.right);
    }
    void postOrder(Node currNode){

        if(currNode==null){
            return;
        }

        postOrder(currNode.left);

        postOrder(currNode.right);
        System.out.print(currNode.data+" ");
    }

    Node addNode(Node currNode,int key){

        if(currNode==null){

            Node newNode =  new Node(key);
            return newNode;
        }

        if(currNode.data<key){

            currNode.right = addNode(currNode.right,key);
        }else
            currNode.left = addNode(currNode.left,key);


        return currNode;
    }
    int count =0,sum =0;
    int sumLeafNodes(Node root){
        if(root == null)
            return 0;
//        if(root.left == null && root.right == null)
//            sum = sum + root.data;
//
//        sumLeafNodes(root.left);
//        sumLeafNodes(root.right);
//        return sum;

        if(root.left == null && root.right == null)
            return root.data;
        int s1 = sumLeafNodes(root.left);
        int s2 = sumLeafNodes(root.right);

        return s1+s2;

    }
}
/* Name of the class has to be "Main" only if the class is public. */
public class solution
{
    public static void main (String[] args) throws java.lang.Exception
    {

        Tree bst = new Tree();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0;i<n;i++){

            int a = sc.nextInt();
            bst.root = bst.addNode(bst.root,a);
        }


        bst.inOrder(bst.root);
        System.out.println();
        bst.preOrder(bst.root);
        System.out.println();
        bst.postOrder(bst.root);


        int sum = bst.sumLeafNodes(bst.root);
        System.out.println();
        System.out.println(sum);

        // your code goes here
    }
}
