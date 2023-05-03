package Tree07;

/**
 * @ author Egcoo
 * @ date 2022/8/23 - 16:32
 */
public class isBalanced55 {

    static boolean ok = true;

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        maxDepth(root);
        return ok;
    }

    public static int maxDepth(TreeNode root) {
        //树的深度 左子树的深度和右子树深度中，更大的值 + 1
        //给一个出口
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            ok = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
