package class6;

/**
 * @ author Egcoo
 * @ date 2023/1/14 - 18:08
 */
public class Edge {
    //只需要管有向边，无向边可以认为是两条有向边拼接而成
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
