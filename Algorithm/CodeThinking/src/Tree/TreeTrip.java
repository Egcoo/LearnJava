package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/24 - 23:32
 */
public class TreeTrip {

    //1.前序遍历(头左右)
    // 弹出就打印
    //  有右节点就压入右节点
    //  有左节点就压入左节点
    //
    public static void preOrder(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);

            while (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val + " ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }


    //2.后序遍历
    // 弹出就打印
    // 另开一个辅助栈 接收 遍历结果
    //  如有左，压入左
    //  如有右，压入右
    //
    public static void postOrder(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(node);
            while (!stack1.isEmpty()) {
                node = stack1.pop();
                stack2.push(node);
                if (node.left != null) {
                    stack1.push(node.left);
                }
                if (node.right != null) {
                    stack1.push(node.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().val + " ");
            }
        }
    }

    //3.中序遍历(左 头 右)
    // 每颗子树，整棵子树左边界进栈，依次弹出的过程中打印，对弹出节点的右树也这么做
    //
    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //3.后续遍历炫技版
    //  1.利用临近状态的关系，标记当前节点的左右子树处理完了没
    //  2.追踪上次打印的节点，标记当前节点的子过程处理完了没
    //      1.左子树处理完有两种情况，要么上次处理的是左树，要么上次处理的是右树
    //  3.论 h 的作用：没有打印完不要干扰我去压入左边界，打印以后确保我可以用 h 标记右子树，有没有用完
    //  4.有左节点先处理左节点，无左就处理右节点

    public static void posOrder(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            //node 要在一个合适的位置，能让你第一个逻辑分支走完，也就是左边界全部进栈
            stack.push(node);
            TreeNode c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && node != c.left && node != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && node != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().val + " ");
                    node = c;
                }
            }
        }
    }

    // 广度优先遍历
    // 使用队列先放左，再放右，弹出就打印
    public static void bfs(TreeNode node) {
        if (node != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }


    //广度优先遍历统计最大宽度（队列 + Map）
    //1. 如果和我当前的层是一层，就直接 ++；如果不是一层，说明新的层开始了，
    //新层开始以后，先更新 max （最大宽度），同时当前层 + 1，并且当前节点数量从 1 开始，继续统计。
    //2. 每一个节点在进队列的时候把它的层记好，因为我知道它父节点的层数，所以子节点的层数就是 +1 就行；
    // 所以当一个节点弹出的时候我就一定可以拿到它的层数。
    //3. 但是 max 的机制一定是新层到来去结算老层，就意味着最后一层是没有被比较过的，最后要单独抓一下最后一层。

    public static int bfs1(TreeNode node) {
        if (node == null) {
            return 0;
        }

        //队列在整个算法中，提供的功能是遍历的工具
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        //这里map 就要出现, key 表示当前存入 map 的节点，value 代表当前节点在那一层
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(node, 1);
        int curLevel = 1; //表示你当前正在统计哪一层
        int curLevelNodes = 0; //当前 level 层的宽度是多少
        int max = 0;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (curLevel == curNodeLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            if (cur.left != null) { //进队列的时候也要记录其节点所在的层数
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }

        max = Math.max(max, curLevelNodes);
        return max;
    }


    //广度优先遍历统计最大宽度 （只是用队列）
    // 1.这里我们不关注，到底是在那一层，我们只关注最大深度，也就是每一层都发现结束的时刻，更新max 就可以
    // 2.当前层我们永远在更新下一层的最右节点
    //
    //

    public static int bfs2(TreeNode node) {
        if (node == null) {
            return 0;
        }

        //队列在整个算法中，提供的功能是遍历的工具
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode curEnd = node; //当前层的最后一个节点
        TreeNode nextEnd = null; //下一层的最后一个节点
        int max = 0;
        int curLevelNodes = 0; //当前节点的数量

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = curEnd.right;
            }
            curLevelNodes++;
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }

    //第三部分：树的序列化和反序列化
    //3.1 深度优先的序列化
    public static Queue<String> preSerial(TreeNode node) {
        Queue<String> ans = new LinkedList<>();
        pres(node, ans);
        return ans;
    }

    public static void pres(TreeNode node, Queue<String> ans) {
        if (node == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(node.val));
            pres(node.left, ans);
            pres(node.right, ans);
        }
    }

    // 3.2 广度优先的序列化和反序列化
    // 序列化就是把树转换成 字符串数组的形式保存下来，树的左右子树如果为空节点，则使用 null 代替
    // 无论如何都要序列化
    public static Queue<String> levelSerial(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.val));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    ans.add(String.valueOf(cur.left.val));
                    queue.add(cur.left);
                } else {
                    ans.add(null);
                }

                if (cur.right != null) {
                    ans.add(String.valueOf(cur.right.val));
                    queue.add(cur.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }
    //

}
