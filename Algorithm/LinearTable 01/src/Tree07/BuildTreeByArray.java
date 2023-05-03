package Tree07;

import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2022/8/8 - 11:25
 * <p>
 * 根据前序、中序遍历结果构造二叉树
 * 测试的前序结果为 [1，2，3，4，5] 中序结果 [3,4,2,1,5]
 */
public class BuildTreeByArray {
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 3, 4, 5};
        int[] inOrder = {3, 4, 2, 1, 5};
        int[] postOrder = {4, 3, 2, 5, 1};

        TreeNode node1 = buildTree(preOrder,inOrder);
        TreeNode node = buildTree1(inOrder,postOrder);
        System.out.println();

    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null) return null;

        //在前序结果中，找到根节点
        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);

        //查找根节点在中序遍历中的位置
        int leftSize = find(inOrder, rootValue);

        // 切分出左子树的前序和中序结果
        // 使用 Array.copyOfRange 方法 三个参数  原始数组 起始位置 终止位置
        // [起始位置，终止位置)
        //
        // 2 3 4 [1, leftSize + 1]
        //
        // 3 4 2 [0, leftSize)
        // 这里为什么是 leftSize + 1 啊，原因是数组下标是从零开始的
        // 这里得到的 leftOrder 是根节点的左子树
        //
        int[] leftOrder = Arrays.copyOfRange(preOrder, 1, leftSize + 1);
        int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, leftSize);
        root.left = buildTree(leftOrder, leftInOrder);

        // 切分出右子树的前序和中序
        //
        // 5 [leftSize + 1,end)
        // 5 [leftSize + 1,end)
        int[] rightPreOrder = Arrays.copyOfRange(preOrder, leftSize + 1, preOrder.length);
        int[] rightInOrder = Arrays.copyOfRange(inOrder, leftSize + 1, inOrder.length);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }


    public static TreeNode buildTree1(int[] inOrder, int[] postOrder) {
        if (postOrder.length == 0 || inOrder.length == 0) return null;

        //在后序结果中，找到根节点
        int rootValue = postOrder[postOrder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        //查找根节点在中序遍历中的位置
        int leftSize = find(inOrder, rootValue);

        // 切分出左子树的中序和后续的结果
        // 使用 Array.copyOfRange 方法 三个参数  原始数组 起始位置 终止位置
        // [起始位置，终止位置)
        //
        // 3 4 2 [0, leftSize)
        // 4 3 2 [0, leftSize)
        // 这里为什么是 leftSize  啊，原因是数组下标是从零开始的
        // 这里得到的 leftInOrder 是根节点的左子树
        //
        int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, leftSize);
        int[] leftPostOrder = Arrays.copyOfRange(postOrder, 0, leftSize);
        root.left = buildTree1(leftInOrder, leftPostOrder);

        // 切分出右子树的中序和后序
        //
        // 5 [leftSize + 1,end)
        // 5 [leftSize ,end -1) 最后一位还有一个根元素
        int[] rightInOrder = Arrays.copyOfRange(inOrder, leftSize + 1, inOrder.length);
        int[] rightPostOrder = Arrays.copyOfRange(postOrder, leftSize, inOrder.length - 1);
        root.right = buildTree1(rightInOrder, rightPostOrder);

        return root;
    }

    public static int find(int[] inOrder, int rootValue) {
        for (int i = 0; i < inOrder.length; i++) {
            if (rootValue == inOrder[i]) {
                return i;
            }
        }
        return -1;
    }
}
