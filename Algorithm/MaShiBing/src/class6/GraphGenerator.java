package class6;

/**
 * @ author Egcoo
 * @ date 2023/1/15 - 15:52
 */
public class GraphGenerator {

    //matrix 所有的边
    // N*3 的矩阵
    // [weight,from节点上面的值，to节点上面的值]
    // 将一个二维数组也就是一个矩阵，构建成一个图的结构
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        //
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            //将两个点拿出来
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            // 将新的边建好
            Edge newEdge = new Edge(weight, fromNode, toNode);
            // 在from的邻居里，就要把to加上
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            // from新拥有了一条边
            fromNode.edges.add(newEdge);
            //放到边集里去
            graph.edges.add(newEdge);
        }
        return graph;
    }
}