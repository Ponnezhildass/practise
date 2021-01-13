public class DeepestLeaves {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNodeWrap node = getHeight(root);
        return node.treeNode;
    }

    public TreeNodeWrap getHeight(TreeNode root){
        if(root.left == null && root.right == null) {
            return new TreeNodeWrap(root,1);
        }

        TreeNodeWrap left , right ;

        if(root.left == null){
            left = new TreeNodeWrap(null, 0);
        } else {
            left = getHeight(root.left);
        }

        if(root.right == null) {
            right = new TreeNodeWrap(null,0);
        } else {
            right = getHeight(root.right);
        }

        if(left.height == right.height) {
            return new TreeNodeWrap(root, left.height +1);
        }

        if(left.height > right.height){
            left.height++;
            return left ;
        } else {
            right.height++;
            return right;
        }

    }


    static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    static class TreeNodeWrap{
        TreeNode treeNode;
        int height;
        TreeNodeWrap(TreeNode treeNode, int height) {
            this.treeNode = treeNode;
            this.height = height;
        }
    }

    public static void main(String[] a){
        DeepestLeaves deepestLeaves = new DeepestLeaves();

        int[] array = {0,1,3,2};
        int i =0;

        TreeNode root = new TreeNode(array[i++]);
        root.left = new TreeNode(array[i++]);
        root.right = new TreeNode(array[i++]);
        root.left.right = new TreeNode(array[i++]);



        System.out.println(deepestLeaves.subtreeWithAllDeepest(root).val);
    }
}
