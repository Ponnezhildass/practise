import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinKTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {

        TreeNode tree = constructTree(root, 1);

        TreeNode node = tree;
        TreeNode ptr = root;

        while(node != null){
            if(node.val == k) return ptr.val;
            else if(node.val > k) {
                node = node.left;
                ptr = ptr.left;
            } else {
                node = node.right;
                ptr = ptr.right;
            }
        }

        return -1;

    }


    public TreeNode constructTree(TreeNode root, int count){
        if(root == null) return null;
        TreeNode treenode = new TreeNode(count);
        if(root.left == null && root.right == null) return treenode;
        TreeNode left = null ;
        TreeNode right = null ;
        if(root.left != null)
            left = constructTree(root.left,count);

        if (left != null){
            TreeNode ptr = left;
            while(ptr.right != null){
                ptr = ptr.right;
            }
            treenode.val = ptr.val +1;
        }

        if(root.right != null)
            right = constructTree(root.right,treenode.val+1);
        treenode.left = left;
        treenode.right = right;


        int[][] points = {};
        PriorityQueue<Integer> queue = new PriorityQueue((Comparator<Integer>) (x, y) -> (MinKTree.this.dist(points[x][0], points[x][1]) - MinKTree.this.dist(points[y][0], points[y][1])));
        return treenode;
    }

    public Integer dist(int x, int y){
        return x*x+y*y;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new MinKTree().kthSmallest(root, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
