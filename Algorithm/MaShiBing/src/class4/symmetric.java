package class4;

import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2023/1/9 - 18:03
 * <p>
 * 判断是否为回文单链表
 * 正常做法：一个链表一个栈，栈弹出比对
 * 面试做法：不使用额外空间，去判断
 */
public class symmetric {
    public static void main(String[] args) {


    }

    //暴力方法判断是否为回文链表
    // need a extra space
    // 取出一个额外的栈，将所有元素压入栈，然后将链表元素顺序遍历和栈弹出的元素依次比对
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //方法2：快慢指针
    // 不使用额外空间，用有限的变量完成判断
    // 快指针一次两步，慢指针一次一步，快指针走完的时候，慢指针来到中点位置
    // 中点往下遍历的时候将其逆序，将后半部分镜像往回指，然后将每一个元素判断
    // 最后把链表恢复
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next; // mid
            n2 = n2.next.next;// n2->end
        }
        n2 = n1.next; //n2 -> right part first node
        n1.next = null;// mid.next -> null
        ListNode n3 = null;
        while (n2 != null){ // 将右半部分转向
            n3 = n2.next; // 在当前节点转向之前，保存后面的节点
            n2.next = n1; // 当前节点转换
            n1 = n2;
            n2 = n3;
        }
        n3 = n1; // n3回到最后一个节点
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null){
            if (n1.val != n2.val){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        while (n1 != null){ // 将数组恢复
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
