package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class LeftViewTraversal {
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
    public  TreeNode insert(TreeNode currNode, int key){
        if(currNode == null){
            currNode = new TreeNode(key);
            return currNode;
        }
        else {
            if(currNode.data < key)
                currNode.right = insert(currNode.right, key);
            else
                currNode.left = insert(currNode.left, key);
        }
        return currNode;
    }
    private void printTreeLevels(TreeNode currNode, int level){
        if (currNode == null)
            return;
        System.out.println(currNode.data+" --> "+ level);
        printTreeLevels(currNode.left, level+1);
        printTreeLevels(currNode.right , level+1);
    }
    int printLevel;
    ArrayList<Integer> li;
    void preOrder(TreeNode currNode, int level){
        if (currNode == null)
            return;
        if(level >printLevel){
            li.add(currNode.data);
            printLevel = level;
        }
        preOrder(currNode.left, level+1);
        preOrder(currNode.right, level+1);
    }


    private ArrayList<Integer> leftView(TreeNode currNode){
        printLevel =-1;
        li = new ArrayList<>();
        System.out.println("Left View of a Tree");
        preOrder(currNode,0);
        return li;
    }
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        LeftViewTraversal lv = new LeftViewTraversal();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            lv.root = lv.insert(lv.root, sc.nextInt());
        }
        ArrayList<Integer> al = new ArrayList<>();
        al = lv.leftView(lv.root);
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");

        System.out.println();
        System.out.println("Nodes with their Levels\n Node       level");
        lv.printTreeLevels(lv.root, 0);

    }
}
