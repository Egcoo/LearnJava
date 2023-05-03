package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/8/16 - 17:38
 */
public class hasCycle141 {

    //使用快慢指针来判断有没有环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        //当链表为空时， fast会首先走到链表尾部
        while (true){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
    }
}
