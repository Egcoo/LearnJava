package Tree07;

/**
 * @ author Egcoo
 * @ date 2022/8/6 - 18:54
 * Make it work,Make it right,Make it fast.
 *
 * 100. 相同的树
 */
public class isSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //递归解决就是两方面，一是寻找递归规律，二是设置递归出口
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        //规律
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
