package trees;

import java.util.Scanner;


public class BinarySearchTree {
    private class ListNode{
        private int data;
        private ListNode lchild;
        private ListNode rchild;

        ListNode(int num){
            this.data = num;
            this.lchild = null;
            this.rchild = null;
        }
    }
    int sum,Lsum;
    ListNode root;
    ListNode insert(ListNode currNode, int num){
        if (currNode == null){
            currNode = new ListNode(num);
            return currNode;
        }
        else {
            if(currNode.data < num)
                currNode.rchild = insert(currNode.rchild, num);
            else
                currNode.lchild = insert(currNode.lchild, num);
        }
        return  currNode;
    }
    void inOrder(ListNode root){
        if(root == null)
            return;
        inOrder(root.lchild);
        System.out.print(root.data + " ");
        inOrder(root.rchild);
    }
    public void preOrder(ListNode root) {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.lchild);
        preOrder(root.rchild);
    }
    public void postOrder(ListNode root){
        if (root == null)
            return;
        postOrder(root.lchild);
        postOrder(root.rchild);
        System.out.print(root.data +" ");
    }
    public  void  SumOfNodes(ListNode root){
        if (root == null)
            return;
        sum = sum+ root.data;
        SumOfNodes(root.lchild);
        SumOfNodes(root.rchild);
    }
    public  void  LeafNodesSum(ListNode root) {
        if (root == null)
            return;
        if (root.lchild == null && root.rchild == null)
            Lsum = Lsum + root.data;
        LeafNodesSum(root.lchild);
        LeafNodesSum(root.rchild);
    }
    public int maxDepth(ListNode root){
        if(root.lchild == null && root.rchild == null)
            return 1;
        int lDepth = maxDepth(root.lchild);
        int rDepth = maxDepth(root.rchild);
        return  Math.max(lDepth,rDepth)+1;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            bst.root = bst.insert(bst.root, sc.nextInt());
        }
        System.out.println("Inorder Traversal of Tree");
        bst.inOrder(bst.root);
        System.out.println();

        System.out.println("Preorder Traversal of Tree");
        bst.preOrder(bst.root);
        System.out.println();

        System.out.println("PostOrder Traversal of Tree");
        bst.postOrder(bst.root);
        System.out.println();

        bst.SumOfNodes(bst.root);
        System.out.println("sum of all Nodes : " + bst.sum);

        bst.LeafNodesSum(bst.root);
        System.out.println("sum of all Leaf Nodes : " + bst.Lsum);
        int height = bst.maxDepth(bst.root);
        System.out.println(height);



    }


}
