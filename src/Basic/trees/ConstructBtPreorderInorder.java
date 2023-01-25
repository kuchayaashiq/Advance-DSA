package trees;

public class ConstructBtPreorderInorder {
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
    private void postOrder(TreeNode root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    private static TreeNode constructBT(int[] preorder,int psi, int pei, int[] inorder,int isi,int iei) {
        if(isi > iei)
            return null;
        int index = isi;
        while (inorder[index]!= preorder[psi])
            index++;
        int countLSE = index-isi;
        TreeNode node = new TreeNode(preorder[psi]);
        node.left = constructBT(preorder, psi+1,psi+countLSE, inorder, isi, index-1 );
        node.right = constructBT(preorder,psi+countLSE+1,pei, inorder,index+1, iei );
        return node;
    }
    public static void main(String[] args) {
        int preorder[] = {0,1, 3, 7, 8, 4, 9, 10, 2, 5, 11, 6};
        int inorder[] = {7, 3, 8, 1, 9, 4, 10, 0, 11, 5, 2, 6};
        ConstructBtPreorderInorder bt = new ConstructBtPreorderInorder();
        int n = preorder.length;
        bt.root = constructBT(preorder,0,n-1, inorder,0,n-1);
        bt.postOrder(bt.root);
    }


}
