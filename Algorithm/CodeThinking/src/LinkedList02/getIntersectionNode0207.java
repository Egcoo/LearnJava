package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/8/15 - 21:32
 * important
 * 1.先求出两个链表的长度，接着算出差值，让 A移动到那个差值
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class getIntersectionNode0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        // 让 A 成为那个最长链表的头，lenA是其长度
        if (lenB > lenA) {
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        //长度差
        int gap = lenA - lenB;
        //让 curA 和 curB在同一起跑线
        while (gap > 0) {
            curA = curA.next;
            gap--;
        }
        // 遍历链表剩余的部分，遇到相同的就直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        //无相同部分
        return null;
    }


    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int LenA = 0, LenB = 0;
        while (curA != null) {
            curA = curA.next;
            LenA++;
        }
        while (curB != null) {
            curB = curB.next;
            LenB++;
        }

        //让节点重新归零
        curA = headA;
        curB = headB;
        // 这一步是我没有想到的，就是你固定一个节点作为最长的那个
        if (LenB > LenA) {
            int tempLen = LenB;
            LenB = LenA;
            LenA = tempLen;
            // 现在交换头节点
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }

        int gap = LenA - LenB;
        while (gap > 0){
            curA = curA.next;
            gap--;
        }
        // 现在遍历链表同长度的部分
        while (curA != null && curA.val != 1){
            if (curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;

    }
}
