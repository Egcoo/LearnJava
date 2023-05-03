package LinkedList02;

/**
 * @ author Egcoo
 * @ date 2022/7/26 - 17:57
 */
public class Josephus {
    public static void main(String[] args) {
        System.out.println("41, 3 -> " + josephus(41,3));
    }

    public static int josephus(int n, int m){
        //初始化环形链表
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        ListNode node = ListNode.arrayToListNode(arr);
        ListNode.toCycle(node,0);

        //将每个人视作链表中的一个节点,当报数到m的时候,删除节点,直到剩下最后一个节点
        //当找到报读 m -1 的节点时,node  node.next = node.next.next;
        //当只剩下最后一个节点时, node.next = next
        int cnt = 1;
        while (true){
            if (cnt == m-1){
                System.out.println("删除节点 " + node.next);
                node.next = node.next.next;
                cnt = 0;
            }
            node = node.next;
            cnt ++;

            if (node.next == node){
                return node.hashCode();
            }
        }
    }

    //方法2:使用数组来遍历
    public static int josephus1(int n, int m){
        int[] people = new int[n];

        // 人的索引
        int index = -1;
        //报数 1,2 ....0
        int cnt = 0;
        // 剩余人数
        int remain = n;
        while (remain > 0){
            index ++;
            //到达数组末端 重新从头遍历
            if (index >= n) index = 0;

            //如果此人 死掉 跳过 继续报数
            if (people[index] == -1){
                continue;
            }
            //报数到 m,将index 对应的位置的元素 置为 -1
            if (cnt == m){
                people[index] = -1;
                cnt = 0;
                remain--;
            }
            cnt++;
        }
        return index;
    }
}
