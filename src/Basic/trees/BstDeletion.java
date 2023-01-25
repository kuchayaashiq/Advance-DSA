package trees;

import java.util.Scanner;

public class BstDeletion {
    private class TreeNode{
        private  int data;
        private  TreeNode left;
        private  TreeNode right;


        // constructor
        TreeNode(int key){
            this.data = key;
            this.left = null;
            this.right = null;
        }
    }
    TreeNode root;
    private  TreeNode insert(TreeNode currNode, int key){
        if (currNode == null){
            currNode = new TreeNode(key);
            return currNode;
        }
        else{
            if (key > currNode.data)
                currNode.right = insert(currNode.right, key);
            else if (key < currNode.data)
                currNode.left = insert(currNode.left, key);
            else
                return currNode;
        }
        return currNode;
    }
    private  void InOrder(TreeNode root){
        if (root == null)
            return;
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }
    private TreeNode deleteNode(TreeNode root, int num){
        if(root == null)
            return root;
        else if (num > root.data) {
            root.right = deleteNode(root.right, num);
        }
        else if (num< root.data) {
            root.left = deleteNode(root.left, num);
        }
        else{
            // No child
            if(root.right == null && root.left == null)
                return null;

            // one child
            else if(root.right == null || root.left == null){
                TreeNode temp = null;
                if(root.left == null){
                    temp = root.right;
                }
                else
                    temp = root.left;
                return temp;
            }
            // Two Childrens
            else {
                TreeNode temp = findMinimum(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }
        return root;
    }

    private TreeNode findMinimum(TreeNode root) {
        if(root == null)
            return null;
        else if(root.left != null)
            return findMinimum(root.left);
        return root;
    }

    public static void main(String[] args) {
        // DATA : 16 ---> No. of Nodes
        //       80 70 200 10 75 150 250 90 50 210 30 140 205 203 120 207
        Scanner sc = new Scanner(System.in);
        BstDeletion bst = new BstDeletion();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            bst.root = bst.insert(bst.root, sc.nextInt());
        }
        System.out.println("Data in a Binary Search Tree before deleting any node :");
        bst.InOrder(bst.root);
        System.out.println();

        bst.deleteNode(bst.root, 200);
        System.out.println("Data in a Binary Search Tree After deleting any node :");
        bst.InOrder(bst.root);
    }
}
