package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/8/13 - 22:22
 */

/*
get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，
则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/design-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
public class ListNode {

    // 结点的值
    int val;

    // 下一个结点
    ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }
}
 */

    //1.关于边界条件处理要使用一些极端的例子
    //2.我们要处理的第 n 个节点，一定是 cur.next ,这样我们才能用 cur 来操作这个节点
    //head 是一个虚拟头节点，所以需要从下一个开始遍历
    //指定一个临时指针来操作链表，而不是直接操作头节点
    // 因为最后我们要返回头节点，如果上了就操作头节点，你头节点值都改了，最后返回也会有问题
public class MyLinkedList707 {

    //size存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode dummyHead;

    //初始化链表
    public void MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0);
    }

    public int get(int index) {
        //如果值非法则返回-1
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = dummyHead.next;

        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        //这个顺序极其重要，反向就会导致数据丢失
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;

        size++;

    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = dummyHead;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;

    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode cur = dummyHead;
        while (index > 0){
            cur = cur.next;
            index--;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;

    }

    public void deleteAtIndex(int index) {
        ListNode cur = dummyHead;
        //合法性判断
        if (index < 0 || index >= size) {
            return;
        }
        while (index > 0){
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        size--;

    }
}
