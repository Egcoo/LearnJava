package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/7/21 - 18:01
 */
public class reverseList {


    public static ListNode ReverseList(ListNode head) {

        //记录前置节点和当前节点
        ListNode pre = null;
        ListNode cur = head;

        //不断向后移动 cur 节点 向后遍历 同时更改其next
        while (cur.next != null){
            ListNode temp = cur.next;
            //创建连接关系，将前一个节点的 next 设置为当前节点
            cur.next = pre;

            //更新 pre 为当前节点,向后移动
            pre = cur;
            cur = temp;
        }

        return  pre;

    }
}
