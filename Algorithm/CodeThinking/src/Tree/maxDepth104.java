package Tree;

/**
 * @ author Egcoo
 * @ date 2022/8/23 - 21:05
 */
public class maxDepth104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;


    }
}
