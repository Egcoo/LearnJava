package Recursion;

import LinkedList02.ListNode;

/**
 * @ author Egcoo
 * @ date 2022/8/20 - 17:38
 */
public class mergeTwoLists21 {

    //1.虚拟头节点  平平淡淡才是真
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (list1 != null && list2 !=null){
            if (list1.val < list2.val){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if (list1 == null){
            cur.next = list2;
        } else {
            cur.next = list1;
        }

        return dummyHead.next;
    }
}
