package trees;

public class constructBstFromPreOrder {
    private static class TreeNode{
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
    static int index =0;
    private static TreeNode constructBST(int[] preorder, int lr, int rr) {
        if(index >= preorder.length || preorder[index] < lr || preorder[index] > rr)
            return null;
        TreeNode node =  new TreeNode(preorder[index++]);
        node.left = constructBST(preorder,  lr, node.data);
        node.right = constructBST(preorder, node.data, rr);

        return node;
    }

    private void InOrder(TreeNode root) {
        if(root == null)
            return;
        InOrder(root.left);
        System.out.print(root.data+" ");

        InOrder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {30, 20, 10, 15, 25, 23, 39, 35, 42};
        constructBstFromPreOrder bst = new constructBstFromPreOrder();
        int lr = -(int)1e9 -1;
        int rr = (int)1e9 +1;
        bst.root = constructBST(preorder, lr, rr);
        bst.InOrder(bst.root);
    }


}
