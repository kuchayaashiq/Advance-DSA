package trees;

public class ConstructBST_FromInorder {
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
    public static void main(String[] args) {
        int[] Inorder = {9,12,14,17,19,23,50,54,67,72,76};
        ConstructBST_FromInorder bst = new ConstructBST_FromInorder();
        bst.root = constructBST(Inorder,0,Inorder.length-1);
        bst.preOrder(bst.root);
    }

    private void preOrder(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static TreeNode constructBST(int[] Inorder, int si, int ei) {
        if(si > ei)
            return null;
        int mid = (si + ei )/2;
        TreeNode node = new TreeNode(Inorder[mid]);
        node.left = constructBST(Inorder,si, mid-1);
        node.right = constructBST(Inorder,mid+1, ei);
        return  node;
    }
}
