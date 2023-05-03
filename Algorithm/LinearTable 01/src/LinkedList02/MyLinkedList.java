package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/11/10 - 22:53
 */
// 1.关于边界处理要使用一些比较极端的例子
// 2.你想处理第 n 个节点，一定是cur.next 才能处理第 n 个节点

public class MyLinkedList {
    // 定义元素的个数
    int size;
    // 指定出来虚拟头节点
    ListNode dummyHead;

    // 一个构造器
    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0);
    }

    public int get(int index) {
        // 安全性检查
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = dummyHead.next;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.data;

    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = dummyHead;
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = dummyHead;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        size++;

    }

    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        ListNode cur = dummyHead;
        ListNode node = new ListNode(val);
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        ListNode cur = dummyHead;
        if (index < 0 || index >= size) {
            return;
        }
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        size--;

    }
}
