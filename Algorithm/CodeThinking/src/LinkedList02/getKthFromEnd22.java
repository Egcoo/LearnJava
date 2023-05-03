package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/8/13 - 12:08
 */
public class getKthFromEnd22 {

    //2.解法2 ：快慢指针法
    // 先定义额外指针，让其先到 第 k 个节点
    // 两个指针同时向后移动，当快的指针移动到末尾时，慢的指针正好到第 k - 1 个节点
    //
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < k-1; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }



    //1.暴力解法：先遍历出链表的总长度k，倒数第 k 个节点 = 正数第 n - k  + 1 个节点
    public ListNode getKthFromEnd1(ListNode head, int k) {

        if (head == null) return null;
        //先看有多少个节点
        int n = 0;
        ListNode temp = head;
        while (temp.next != null){
            n++;
            temp = temp.next;
        }
        //这一步就是让 temp 指向那个节点
        temp = head;
        for (int i = 0; i < n - k + 1; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
