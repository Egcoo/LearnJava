package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/8/14 - 18:06
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * /*
 * 算法程序如何展开
 * 1. 又简单到复杂
 * 1.1 验证一步走一步
 * 1.2 多打印中间结果
 * 2. 先局部后整体
 * 2.1没思路时先细分
 * 3. 先粗糙后精细
 * 3.1变量更名
 * 3.2语句合并
 * 3.3边界处理
 */

public class swapPairs24 {

    //1.使用虚拟头节点解决 平平淡淡才是真
    //遍历结束的终止条件要想清楚
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        //cur.next 处理的是偶数，cur.next.next 处理的是奇数
        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next; //1
            ListNode temp2 = cur.next.next.next; //3
            cur.next = cur.next.next;
            cur.next.next = temp1;
            temp1.next = temp2;
            //cur 向前走
            cur = cur.next.next;
        }
        return dummyHead.next;
    }


    // 虚拟头节点+ 平平淡淡才是真
    public ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead.next;

        ListNode temp1 = dummyHead;
        while (cur != null && cur.next != null) {
            temp1.next = cur.next;
            cur.next = temp1.next.next;
            temp1.next.next = cur;

            temp1 = cur;
            cur = cur.next;

        }
        return dummyHead.next;
    }


}
