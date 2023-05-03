package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/8/13 - 15:49
 */
public class removeElements203 {

    //1.dummy head 虚拟头节点
    //优点就是代码统一
    public ListNode removeElements(ListNode head, int val) {

        ListNode header = new ListNode(-1);
        header.next = head;
        //定义出一个临时指针，
        //如果使用头节点进行遍历，头节点的值是在不断改变的，最后没有办法返回原先链表的头节点
        ListNode cur = header;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        //这里为什么不会 return head，因为head有可能已经被我们删除了
        return header.next;
    }


    // 203 移除链表元素 在链表中很重要的一个方法就是虚拟头节点
    // 最直接的优点就是代码统一
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 这里需要定义出来一个额外的指针，头节点是在不断改变，最后没有办法返回原先链表的头节点
        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        // 这里不返回head 的原因是head 可能已经被我们删除了
        return dummyHead.next;
    }




    //2.原链表删除元素
    //分为两种情况：删除头节点和删除中间节点
    public ListNode removeElements1(ListNode head, int val) {
        //删除头节点
        while (head != null && head.val == val){
            head = head.next;
        }
        //如果这样是合理的话，那么前后修改的应该是一份数据
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return head;
    }

}
