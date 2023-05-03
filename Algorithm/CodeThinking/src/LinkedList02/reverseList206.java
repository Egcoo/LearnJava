package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/8/14 - 15:53
 */
//在引用更改时，会丢失原指针 next的引用，所以需要一个 temp 临时指针来记录
public class reverseList206 {

    //2.递归解法（将复杂问题递推分解为最简问题，然后将结果回归） 一找递归公式，二找递归出口
    //
    public ListNode reverseList1(ListNode head) {
        return reverse(head,null);
    }
    public static ListNode reverse(ListNode cur, ListNode pre){
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(temp,cur);
    }

    //1.双指针解法
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        //注意是 cur 不为空，而不是 cur.next 不为空
        while (cur != null){
            ListNode temp = cur.next;

            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    
}
