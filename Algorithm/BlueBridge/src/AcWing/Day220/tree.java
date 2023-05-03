package AcWing.Day220;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/2/23 - 19:54
 * <p>
 * 1.现在右序遍历找到根节点，2.再到中序遍历找到根节点的位置
 * 3.在中序遍历里面根节点会将左右子树的遍历分开   4.然后从而确定左子树长度和右子树长度
 * 5.再到后续遍历里面，左子树的长度和中序遍历中左子树的长度是一样的
 * 6.从而确定右子树长度
 * 7.左右递归
 * <p>
 * 递归本质——数学归纳法，递归和树也是一一对应的，每一次递归都可以化成一棵树
 */
public class tree {

    static int N = 40;
    static int[] l = new int[N]; // 存放左子树的根
    static int[] r = new int[N]; // 存放右子树的根
    static int[] in = new int[N]; // 存放中序遍历的数组
    static int[] po = new int[N]; // 存放后续遍历的数组
    static Map<Integer, Integer> pos = new HashMap<Integer, Integer>(); // 存放中序遍历每个节点的位置

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //两个循环完成初始遍历状态的创建
        for (int i = 0; i < n; i++) {
            po[i] = scanner.nextInt();

        }
        for (int i = 0; i < n; i++) {
            in[i] = scanner.nextInt();
            pos.put(in[i], i);
        }
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);

        int root = build(0, n - 1, 0, n - 1);
        bfs(root);
    }

    //主要的递归程序
    public static int build(int il, int ir, int pl, int pr) {
        int root = po[pr]; //后序遍历的最后一个节点就是根节点
        int k = pos.get(root); // 找到这个节点在中序遍历中所的位置

        // 如果这个中序遍历区间的左端点比根节点小，说明节点有左子树，继续递归遍历
        // 右子树同理
        if (il < k) {
            l[root] = build(il, k - 1, pl, k - 1 - il + pl);
        }
        if (ir > k) {
            r[root] = build(k + 1, ir, k - il + pl, pr - 1);
        }
        return root;

    }

    //bfs的层序遍历
    public static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            System.out.print(t + " ");
            //如有左压入左，如有右，压入右
            //不是很懂
            if (l[t] != -1) {
                queue.add(l[t]);
            }
            if (r[t] != -1) {
                queue.add(r[t]);
            }
        }
    }

}
