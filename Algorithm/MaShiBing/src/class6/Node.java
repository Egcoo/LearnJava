package class6;

import java.util.ArrayList;

/**
 * @ author Egcoo
 * @ date 2023/1/14 - 18:00
 */
public class Node {
    public int value;
    //入度
    public int in;
    //出度
    public int out;

    // 由当前节点发散出去的直接邻居有哪些点
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }
}
