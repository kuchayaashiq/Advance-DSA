package trees;

import java.util.Scanner;

public class MirrorTree {
    private  class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int value){
            this.data = value;
            this.left = null;
            this.right= null;
        }
    }
    TreeNode root;
    public TreeNode insert(TreeNode currNode, int value){
        if(currNode == null){
            currNode = new TreeNode(value);
            return currNode;
        }
        else {
            if(currNode.data <value){
                currNode.right = insert(currNode.right,value);
            }
            else {
                currNode.left = insert(currNode.left,value);
            }
        }
        return  currNode;
    }
    void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode leftAdr = mirrorTree(root.left);
        TreeNode rightAdr = mirrorTree(root.right);
        root.left = rightAdr;
        root.right= leftAdr;

        return root;
    }

    public static void main(String[] args) {
        MirrorTree mt = new MirrorTree();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mt.root = mt.insert(mt.root, sc.nextInt());
        }
        System.out.println("Inorder Traversal of Tree Before Mirror");
        mt.inOrder(mt.root);
        System.out.println();

        mt.root = mt.mirrorTree(mt.root);

        System.out.println("Inorder Traversal of Tree After Mirror");
        mt.inOrder(mt.root);
        System.out.println();
    }


}
