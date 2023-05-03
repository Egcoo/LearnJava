package Tree07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2022/8/7 - 18:10
 * <p>
 * 101. 对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 思路就是拆分成左右子树进行递归判断
 */
public class isSymmetric {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 4, 4, 3};
        TreeNode node = CreateTree.createByArray(arr, 0);

        System.out.println(isSymmetric(node));
    }


    public static boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        //拆分成左右子树，分开判断
        return isMirror(root.left, root.right);
    }

    // 将树拆解为 左子树A 和 右子树B
    // A的左子树 要和 B的右子树一样
    // A的右子树 要和 B的左子树一样
    public static boolean isMirror(TreeNode node1, TreeNode node2) {
        //设置出口
        if (node1 == null && node2 == null) return true;
        //判断是否不对称
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    //用队列实现广度优先遍历

    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        //开始循环比较
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            //如果 node1 2 都为空 就直接开始下一轮比较，因为 节点为空就没有什么左右子树了
            if (node1 == null && node2 == null) continue;
            //判断是否不对称
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
