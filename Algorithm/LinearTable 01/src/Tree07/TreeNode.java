package Tree07;

/**
 * @ author Egcoo
 * @ date 2022/8/6 - 16:49
 * Make it work,Make it right,Make it fast.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

