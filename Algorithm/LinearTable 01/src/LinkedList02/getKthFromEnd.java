package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/7/21 - 16:32
 */
public class getKthFromEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToListNode(arr);
        ListNode node1 = getKthFromEnd1(head, 3);
        System.out.println(node1);

    }

    //解法2：双指针中的 快慢指针
    //先定义额外指针 找到正数的第 k 个节点
    //两个指针同时向后移动，当快的指针到达链表的最后一个节点时
    //慢的指针正好到达倒数第 k 个节点
    //（相当于慢的指针没走的 k 步，由快的指针帮忙走完了）

    public ListNode getKthFromEnd(ListNode head, int k) {
        //快慢指针解决问题
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode getKthFromEnd1(ListNode head, int k) {
        //定义一组快慢指针
        ListNode slow = head;
        ListNode fast = head;

        //这里的结果总是指向下一个节点，所以需要 k -1
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            System.out.println("slow 移动到 " + slow + ", fast 移动到 " + fast);
        }

        return slow;
    }


    //先遍历出链表的总长度 k，倒数第 k 个节点 = 从头遍历的第 n - k + 1 个节点

    public static ListNode getKthFromEnd0(ListNode head, int k) {

        //这一步的目的是要找到一共有多少个节点
        int n = 0;
        ListNode temp = head;
        while (temp.next != null) {
            n++;
            temp = temp.next;
        }

        //这一步是让 temp 指向该节点
        temp = head;
        for (int i = 0; i < n - k + 1; i++) {
            temp = temp.next;
        }

        return temp;

    }


}
