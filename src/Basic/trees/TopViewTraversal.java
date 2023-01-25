package trees;

import java.util.*;

public class TopViewTraversal {
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
    public TreeNode insert(TreeNode currNode, int key){
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
    static class pair{
        int hd;
        TreeNode node;
        pair(int hd, TreeNode node){
            this.hd = hd;
            this.node = node;
        }
    }
    private ArrayList<Integer> topView(TreeNode root) {
        Queue<pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new pair(0, root));
        while (!q.isEmpty()){
            pair cur  = q.remove();
            if (!map.containsKey(cur.hd))
                map.put(cur.hd, cur.node.data);
            if(cur.node.left != null)
                q.add(new pair(cur.hd-1, cur.node.left));
            if (cur.node.right != null)
                q.add(new pair(cur.hd+1, cur.node.right));
        }
        ArrayList<Integer> ans =  new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        TopViewTraversal tv = new TopViewTraversal();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tv.root = tv.insert(tv.root, sc.nextInt());
        }
        ArrayList<Integer> al = new ArrayList<>();
        al = tv.topView(tv.root);
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");


    }


}
