package Tree;

/**
 * @ author Egcoo
 * @ date 2022/8/23 - 21:10
 */
public class minDepth111 {


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null){
            return 1 + minDepth(root.right);
        }
        if (root.left != null && root.right == null){
            return 1 + minDepth(root.left);
        }

        return Math.min(minDepth(root.left) , minDepth(root.right));
    }
}
