package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/8/16 - 17:44
 */
public class detectCycle142 {
    // 0.暴力解法，使用哈希表set，依次遍历链表，如果该节点在哈希表里不存在就将其加入，如果
    // 存在则直接返回，前提是链表元素不存在重复

    // 1.环形链表更像是操场跑圈问题
    public ListNode detectCycle1(ListNode head) {
        //安全性检查
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        //第一次相遇后，fast 重新指向 head ，slow 保持不变
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }



    //1.先判断是否是环形链表，再找环形链表的入口
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            //当前的fast 节点为空或当前节点的下一个为空 直接false
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        //第一次相遇后，fast 重新指向 head ，slow 保持不变
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
