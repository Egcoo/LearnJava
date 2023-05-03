package Tree07;

/**
 * @ author Egcoo
 * @ date 2022/8/6 - 16:51
 * Make it work,Make it right,Make it fast.
 *
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class Depth {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode leftNode = new TreeNode(9);
        treeNode.left = leftNode;
        TreeNode rightNode = new TreeNode(20);
        treeNode.right = rightNode;
        TreeNode subLeft = new TreeNode(15);
        TreeNode subRight = new TreeNode(7);
        rightNode.left = subLeft;
        rightNode.right = subRight;

        maxDepth(treeNode);
        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {

        //树的深度 左子树的深度和右子树深度中，更大的值 + 1
        //给一个出口
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
