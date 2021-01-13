import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTree {
    static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
    public int longestZigZag(TreeNode root) {

        if(root == null) return -1;
        int left = root.left == null ? 1 :longestZigZagUtil(root.left, -1);
        int right = root.right == null ? 1 :longestZigZagUtil(root.right, 1);
        if(left<0) {left = -left; left++;}
        if(right<0) {right = -right; right++;}

        return Math.max(left,right)-1;

        // currPath =1 ->right, currPath = -1 -> left
    }

    public int longestZigZagUtil(TreeNode root, int currPath){
        int left = root.left == null ? 1 :longestZigZagUtil(root.left, -1);
        int right = root.right == null ? 1 :longestZigZagUtil(root.right, 1);
        boolean included = false;
        if(left<0) {
            left--;
            left = -left;
            included = true;
        }
        if(right<0) {
            right--;
            right = -right;
            included = true;
        }
        int result = Math.max(left,right);
        if(result == 1) included =true;
        return included? -result+1: result-1;
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

    int global = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int m = maxPathSumUtil(root);
        return Math.max(global,m);
    }

    public int maxPathSumUtil(TreeNode root){
        if(root == null) return 0;
        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);
        if(left>global) global = left;
        if(right>global) global = right;
        int m = left+root.val+right;
        if(root.val>global) global = root.val;
        if(m>global) global = m;
        if(left<0 && right<0) return root.val;
        return left>right ? left+root.val : right+root.val;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new ZigZagTree().maxPathSum(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

}