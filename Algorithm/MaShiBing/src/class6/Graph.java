package class6;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ author Egcoo
 * @ date 2023/1/14 - 17:58
 *
 * 还是需要做熟悉结构的模板建设
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
