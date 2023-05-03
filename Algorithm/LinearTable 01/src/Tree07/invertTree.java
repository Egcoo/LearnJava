package Tree07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2022/8/8 - 9:34
 * 226. 翻转二叉树
 * <p>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class invertTree {

    //方案1：类似于先序遍历
    public TreeNode invertTree(TreeNode root) {
        //递归两大要素：找规律、找出口
        if (root == null) return null;
        //先将左右子树交换，然后再分别，翻转左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //方案2：中序遍历
    //先反转左子树，再调换左右子树，再翻转左子树（也就是原来的右子树）
    public TreeNode invertTree1(TreeNode root) {
        //递归两大要素：找规律、找出口
        if (root == null) return null;
        //先将左右子树交换，然后再分别，翻转左右子树

        invertTree1(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree1(root.left);
        return root;
    }

    //方案2：后续遍历
    //先反转左子树，再翻转右子树，最后调转左右子树
    public TreeNode invertTree2(TreeNode root) {
        //递归两大要素：找规律、找出口
        if (root == null) return null;
        //先将左右子树交换，然后再分别，翻转左右子树

        invertTree2(root.left);
        invertTree2(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    //方案4：广度优先遍历
    //
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            //取出队头元素并输出
            TreeNode current = queue.poll();

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return root;
    }
}
