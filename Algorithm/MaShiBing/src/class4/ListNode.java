package class4;

/**
 * @ author Egcoo
 * @ date 2023/1/10 - 16:37
 */
public class ListNode {
    // 结点的值
    public int val;

    // 下一个结点
    public ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }



    //1.数组转化为链表
    public static ListNode arrayToListNode(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        //先生成链表的根节点
        ListNode root = new ListNode(arr[0]);

        ListNode pre = root;
        for (int i = 1; i < arr.length; i++) {
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
