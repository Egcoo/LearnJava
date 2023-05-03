package Tree07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/7 - 10:05
 */
public class TreeSearch {
    public static void main(String[] args) {

        TreeNode node = CreateTree.createTree();
        preOrder(node);
        System.out.println("\n---------------------");
        inOrder(node);
        System.out.println("\n---------------------");
        postOrder(node);
        System.out.println("\n---------------------");
        postOrderByLoop(node);
        System.out.println("\n---------------------");

    }

    //深度优先遍历到的三种形式
    //1.前序遍历
    public static void preOrder(TreeNode node) {
        //递归出口
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //2.中序遍历
    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    //3.后序遍历
    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    //4.广度优先遍历的实现
    // 通过队列来实现，从根节点开始存储到队列中
    // 从头开始遍历，存入队头节点的左右孩子，同时取出队头节点
    // 直到队列为空为止，所有节点处理完成，同时节点的顺序是按照层级的

    public static void bfs(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (queue.size() > 0) {
            //取出队头元素并输出
            TreeNode node1 = queue.poll();
            System.out.print(node1.val + " ");

            if (node1.left != null) {
                queue.offer(node1.left);
            }
            if (node1.right != null) {
                queue.offer(node1.right);
            }
        }

    }

    // 5.使用 栈 来模拟 深度优先中的前序遍历
    public static void preOrderByLoop(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        //使用指针记录遍历到哪一个节点
        TreeNode p = node;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.print(p.val + " ");
                stack.push(p);
                p = p.left;
            }
            //左子树都进去了以后开始 弹出栈顶元素，遍历右子树
            //1 2 4 8
            //1 2 9
            //1 5
            //3 6
            //7
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    // 6.使用 栈 来模拟 深度优先中的中序遍历
    public static void inOrderByLoop(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        //使用指针记录遍历到哪一个节点
        TreeNode p = node;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            //左子树都进去了以后开始 弹出栈顶元素，遍历右子树
            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.right;
            }
        }
    }

    // 7.使用 栈 来模拟 深度优先中的后续遍历
    public static void postOrderByLoop(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        //使用指针记录遍历到哪一个节点
        TreeNode p = node;
        //记录上一次访问的哪一个节点
        TreeNode prev = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            //出栈，弹出其栈顶元素，找到其右孩子
            if (!stack.isEmpty()) {
                //节点出栈的逻辑有两种情况
                //1.  当前节点的子节点为空
                //2. 上一次出栈的节点就是当前节点的右节点
                p = stack.pop();
                if (p.right == null || prev == p.right) {
                    System.out.print(p.val + " ");
                    prev = p;
                    p = null;
                } else {
                    //这里就是不满足出栈条件
                    stack.push(p);
                    p = p.right;
                }
            }

        }

    }

}
