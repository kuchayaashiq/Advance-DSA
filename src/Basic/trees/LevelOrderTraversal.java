package trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {
    private  class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int key){
            this.data = key;
            this.left = null;
            this.right = null;
        }
    }
    TreeNode root;
    TreeNode insert(TreeNode currNode, int num){
        if (currNode == null){
            currNode = new TreeNode(num);
            return currNode;
        }
        else {
            if(currNode.data < num)
                currNode.right = insert(currNode.right, num);
            else
                currNode.left = insert(currNode.left, num);
        }
        return  currNode;
    }
    private void levelOrderTraverse(TreeNode node) {
        Queue<TreeNode> lo = new ArrayDeque<>() ;
        lo.add(node);
        while (lo.size() > 0){
            int count = lo.size();
            for (int i = 0; i < count; i++) {
                node = lo.remove();
                System.out.print(node.data+ " ");

                if (node.left != null)
                    lo.add(node.left);
                if (node.right != null )
                    lo.add(node.right);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        LevelOrderTraversal lot = new LevelOrderTraversal();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
           lot.root = lot.insert(lot.root, sc.nextInt());
        }
        lot.levelOrderTraverse(lot.root);
    }


}
