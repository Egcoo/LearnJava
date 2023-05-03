package class5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2023/1/12 - 18:06
 * <p>
 * 整个想法基于我可以向我左树要信息，向右树要信息的情况下，我怎么去列出这个可能性
 * 可能性列出来以后，我再去看我左树要什么信息，右树要什么信息，做一个全集，搞整个递归结构
 * 套路在于 1）告诉你去怎么想这个问题，你可以利用左右两个树的信息去加工可能性
 * 2）怎么写代码，代码结构也告诉你了
 */
public class TreeDP {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(12);
        TreeNode leftNode = new TreeNode(5);
        treeNode.left = leftNode;
        TreeNode rightNode = new TreeNode(18);
        treeNode.right = rightNode;
        TreeNode Left = new TreeNode(2);
        TreeNode right = new TreeNode(9);
        leftNode.left = Left;
        leftNode.right = right;
        TreeNode subLeft = new TreeNode(15);
        TreeNode subRight = new TreeNode(19);
        rightNode.left = subLeft;
        rightNode.right = subRight;
        boolean bst2 = isBST2(treeNode);
        System.out.println(bst2);

        String s = serialByPre(treeNode);
        System.out.println(s);
        Queue<String> queue = new LinkedList<>();
//        queue.add(s);
//        TreeNode treeNode1 = reconPreOrder(queue);

    }
    //----------------------------------------------------------------
    //反序列化
    public static TreeNode reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }

    //---------------------------------------------------------------
    // 以head 为头节点，序列化成字符串返回
    public static String serialByPre(TreeNode head){
        if(head == null){
            return "#_";
        }
        String res = head.val + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;

//        String left = serialByPre(head.left);
//        String right = serialByPre(head.right);
//        return head.val + "," + left + "," + right;
    }

    //----------------------------------------------------------------
    // 查找两个节点的最低公共祖先节点
    //1.O1是O2 的祖先节点，或者O2 是O1的祖先节点
    //2.O1和O2 不互为祖先节点，继续向上才找到
    //3.当一个节点左边不为空，右边也不为空的时候，我会返回我自己
    //
    //
    public static TreeNode lowestCommonAncestor(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        TreeNode left = lowestCommonAncestor(head.left, o1, o2);
        TreeNode right = lowestCommonAncestor(head.right, o1, o2);

        //3.当一个节点左边不为空，右边也不为空的时候，我会返回我自己,用于第二种情况的判断
        if (left != null && right != null) {
            return head;
        }
        //左右两棵树不是都有返回值
        return left != null ? left : right;
    }

    //----------------------------------------------------------------
    //递归套路之求解满二叉树
    public static boolean isFull(TreeNode head) {
        if (head == null) {
            return true;
        }
        Info data = Full(head);
        return data.nodes == Math.pow(2, data.height - 1);
    }

    public static class Info {
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info Full(TreeNode X) {
        if (X == null) {
            return new Info(0, 0);
        }
        Info leftData = Full(X.left);
        Info rightData = Full(X.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }

    //-------------------------------------------------------------------

    // 递归套路之搜索二叉树
    // 1)左树是搜索二叉树 2）右树是搜索二叉树 3）左max < X 右min > X
    // 只需要考虑以X为头的整棵树，几个信息怎么得到
    public static boolean isBST3(TreeNode head) {
        return process2(head).isBST;
    }

    public static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnData process2(TreeNode X) {
        if (X == null) {
            return null;
        }
        ReturnData leftData = process2(X.left);
        ReturnData rightData = process2(X.right);

        int min = X.val;
        int max = X.val;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        // 如果左树不是搜索二叉树，或者左树的最大值大于左树的父节点
        boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= X.val)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || rightData.min <= X.val)) {
            isBST = false;
        }

        return new ReturnData(isBST, min, max);
    }

    //---------------------------------------------------------
    //平衡二叉树
    // |左子树 - 右子树| <= 1
    // 套路的核心在于，向左右两个子树要信息，最后把问题解决
    // 左右树都返回两个值，此时只有X也返回两个值，此时整个递归的程序才能连起来
    public static boolean isBalanced(TreeNode head) {

        return process(head).isBalanced;
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnType process(TreeNode X) {
        if (X == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(X.left);
        ReturnType rightData = process(X.right);
        //左右树都返回两个值，此时只有X也返回两个值，此时整个递归的程序才能连起来
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }

    //---------------------------------------------------------

    //完全二叉树
    //1.任一节点，有右节点无左 false
    //2.在不违反1的条件下，如果遇到了第一个左右子树不双全的情况，后续节点都是子节点
    //3.这是宽度优先遍历的一个应用
    public static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        //是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            // 如果遇到了不双全的节点以后，又发现当前节点居然有孩子节点  || 有右节点无左节点
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    //搜索二叉树 非递归实现
    //1.总体来讲是中序遍历的延展，将中序遍历中的打印行为替换为 搜索二叉树的比较行为
    //
    public static boolean isBST2(TreeNode head) {
        if (head != null) {
            int preVal = Integer.MIN_VALUE;

            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    //将打印行为替换
                    if (head.val <= preVal) {
                        return false;
                    } else {
                        preVal = head.val;
                    }

                    head = head.right;
                }
            }
        }
        return true;
    }

    //----------------------------------------------------------------
    //搜索二叉树 递归实现
    //若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    //1.先检查左树是不是搜索二叉树，如果左树不是就不用查了，然后左树和左树的父节点进行比较
    //2.比较完以后将其设置为 preValue，跟我右树上去比较
    //3.右树上如果是BST 我整棵树就都是了
    //4.总体来讲是中序遍历的延展，将中序遍历中的打印行为替换为 搜索二叉树的比较行为
    public static int preValue = Integer.MIN_VALUE;

    public static boolean isBST(TreeNode head) {
        if (head == null) {
            return false;
        }
        boolean isLeftBst = isBST(head.left);
        if (!isLeftBst) {
            return false;
        }
        if (head.val <= preValue) {
            return false;
        } else {
            preValue = head.val;
        }
        return isBST(head.right);
    }

}