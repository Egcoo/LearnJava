package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/8/15 - 16:57
 * <p>
 * [1,2,3,4,5]
 * 2
 */
public class removeNthFromEnd19 {

    //1.虚拟头节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = 0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        ListNode temp = head;
        while (temp.next != null) {
            index++;
            temp = temp.next;
        }
        for (int i = 0; i < index - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return dummyHead.next;

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //定义一组快慢指针
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        //快指针走 n + 1 步，才能让慢指针正好走到我们要操作的位置
        n++;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummyHead.next;

    }

    // 快慢指针，不过我认为这个是没有加合法性判断的
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        // 快指针走 n+1 步，倒数第n个节点也就是正数第n+1个节点
        n++;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyHead.next;

    }
}
