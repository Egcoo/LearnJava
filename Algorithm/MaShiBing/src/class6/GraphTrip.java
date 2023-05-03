package class6;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2023/1/15 - 16:34
 */
public class GraphTrip {

    // dijkstra 迪杰斯特拉算法—— 非负有向图的最短路径问题
    public static HashMap<Node, Integer> dijkstra(Node from) {
        // 从from 出发到所有点的最小距离
        // key ： 从from出发到达 key
        // value： 从from出发到达key的最小距离
        // 如果在表中，没有 T 的记录，含义是从from 出发到T这个点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);
        //已经求过距离的节点，存在与 selectNodes 中，以后再也不碰
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    // 遍历寻找最短路径 
    public static Node getMinDistanceAndUnselectedNode(
            HashMap<Node, Integer> distanceMap,
            HashSet<Node> selectedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }


    //从node 出发，进行宽度优先遍历
    // 需要使用set的一个不可重复的机制，可以检查 + 去重
    // 既可解决无向图，也可解决有向图的带环的问题
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            //真正在做题的时候就是这一步，把打印换成你想要的处理方式
            System.out.print(cur.value + " ");
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }


    // 深度优先遍历
    // 就是我一旦发现我有某一后续条路没有走过，我先不走其他的路，我就逮着这条路往死里走
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    //把刚弹出来的，和下一个直接扔回去
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    //3.拓扑排序
    // 一个编译问题：当一个图编译好以后，都有各自的依赖，怎么决定编译的顺序呢？
    // 给你一张有向图，怎么安排做事的顺序，最后能让所有的的的依赖环境都具备
    // 思路：找入读为0的节点，找到以后将节点和其影响全部擦除，之后再找入读为0的节点
    //

    public static List<Node> topologicalSort(Graph graph) {
        // key:某一个 node
        // value：剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 入度为0的点，才能进入这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        //干完for循环做了两件事
        //1) 所有点真实的入度存入到了map里面 2）找到了第一批入度为0的点
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        // 拓扑排序的结果，依次加入result
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            // 1.每一个入度减少一个
            // 2.如果减成 0 了，再加入
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

    //-------------------------这部分我不太懂-------------------------
    //最小生成树：保证连通性的前提下，权值的和是最小的
    //
    // kruskal ：使用某种机制实现集合查询和集合合并，就可以实现最小生成树
    // 这里是 K算法的最核心的实现部分
    // prim

    public static class MySets {

        public HashMap<Node, List<Node>> setMap;

        public MySets(List<Node> Nodes) {
            for (Node cur : Nodes) {
                List<Node> set = new ArrayList<Node>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }


}
