package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/7/22 - 17:49
 */
public class CycleList {
    public static void main(String[] args) {
        int[] arr = {3, 2, 0, 4};
        ListNode node = ListNode.arrayToListNode(arr);
        ListNode.toCycle(node, 1);

        int[] arr1 = {1, 2};
        ListNode node1 = ListNode.arrayToListNode(arr1);
        ListNode.toCycle(node1, 0);
        detectCycle(node1);
        System.out.println(detectCycle(node1));


    }

    public static boolean hasCycle(ListNode head) {
        //判断链表是否有意义
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        //当没有链表时，fast 会先走到链表尾部
        while (true) {
            //当前的fast 节点为空或当前节点的下一个为空 直接false
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
    }

    //返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

    public static ListNode detectCycle(ListNode head) {
        //判断链表是否有意义
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        //当没有链表时，fast 会先走到链表尾部
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
        //第一次相遇后，让fast 重新指向 head 节点，slow 保持不变
        //fast 和 slow 以相同的速度移动，再次相遇，此节点为入口节点
        fast = head;
        //这里只是针对 只有两个元素的情况
        if (slow == fast){
            return slow;
        }
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (slow != null) {
                System.out.println("slow 走到" + slow);
            }
            if (fast != null) {
                System.out.println("fast 走到" + fast);
            }
            if (slow == fast) {
                return slow;
            }
        }
    }
}
