package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/8/23 - 20:56
 */
public class inorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
}
