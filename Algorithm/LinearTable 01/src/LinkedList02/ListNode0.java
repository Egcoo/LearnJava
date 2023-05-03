package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/7/20 - 18:36
 */
public class ListNode0 {

    //数据
    String data;
    //下一个节点的引用
    ListNode0 next;

    public ListNode0(String data) {
        this.data = data;
    }

    public static void main(String[] args) {
        String[] arr ={"BTC","ETH","Polygon","地平线4"};
        ListNode0 node = arrayToListNode(arr);
        System.out.println();
    }

    //数组转化为链表
    public static ListNode0 arrayToListNode(String[] arr){
        if (arr.length == 0) return null;

        //先生成链表的根节点
        ListNode0 root = new ListNode0(arr[0]);

        ListNode0 pre = root;
        for (int i = 1; i < arr.length; i++) {
            ListNode0 node = new ListNode0(arr[i]);
            pre.next = node;
            pre = node;
        }
        return root;
    }

}
