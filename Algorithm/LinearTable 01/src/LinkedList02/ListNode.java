package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/7/20 - 18:36
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * <p>
 * 解法：先遍历出链表的总长度 k，倒数第 k 个节点 = 从头遍历的第 n - k + 1 个节点
 */
public class ListNode {

    //数据
    int data;
    //下一个节点的引用
    ListNode next;


    public ListNode(int data) {
        this.data = data;
    }

    public static void main(String[] args) {


    }

    //1.数组转化为链表
    public static ListNode arrayToListNode(int[] arr) {
        if (arr.length == 0) return null;

        //先生成链表的根节点
        ListNode root = new ListNode(arr[0]);

        ListNode pre = root;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            pre.next = node;
            pre = node;
        }
        return root;
    }

    //2.将链表转化为环形链表
    //pos 代表 尾节点指向 链表中的某个节点的索引位置

    public static void toCycle(ListNode node, int pos) {

        int cnt = 0;
        ListNode cyckeNode = null;
        while (true) {
            //判断是否是环的入口节点
            if (cnt == pos) {
                cyckeNode = node;
            }

            //判断是否是尾节点
            if (node.next == null) {
                node.next = cyckeNode;
                return;
            }

            node = node.next;
            cnt++;
        }
    }

}
