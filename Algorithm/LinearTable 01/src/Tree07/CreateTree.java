package Tree07;

import java.util.LinkedList;

/**
 * @ author Egcoo
 * @ date 2022/8/6 - 18:22
 * Make it work,Make it right,Make it fast.
 * <p>
 * 用 集合实现 完全二叉树
 */
public class CreateTree {

    //                           0  1   2   3   4
    //                         2k+1 2k+2
    public static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    //存储生成的节点
    static LinkedList<TreeNode> nodeList = new LinkedList<>();

    public static TreeNode createTree() {
        //构造节点
        for (int i = 0; i < array.length; i++) {
            TreeNode node = new TreeNode(array[i]);
            nodeList.add(node);

        }
        //构造节点之间的关系
        //注意这次 调用 node 是没有 new 的
        for (int i = 0; i < nodeList.size() / 2; i++) {
            TreeNode node = nodeList.get(i);
            node.left = nodeList.get(i * 2 + 1);

            //最后一个父节点，可能无右节点，需要额外判断
            if (i * 2 + 2 < nodeList.size()) {
                node.right = nodeList.get(i * 2 + 2);
            }
        }

        return nodeList.get(0);
    }

    //根据数组的索引位置，关联出左右子树
    public static TreeNode createByArray(Integer[] array, int index) {
        //递归的出口
        if (index >= array.length || array[index] == null) return null;

        //递归的规律
        TreeNode node = new TreeNode(array[index]);
        node.left = createByArray(array, 2 * index + 1);
        node.right = createByArray(array, 2 * index + 2);
        return node;
    }


    public static void main(String[] args) {
        TreeNode createTree = createTree();
        System.out.println();
    }

}
