package graph;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphAdjacencyMatrix.GraphNode> nodeList = new ArrayList<>();

        nodeList.add(new GraphAdjacencyMatrix.GraphNode("A", 0));
        nodeList.add(new GraphAdjacencyMatrix.GraphNode("B", 1));
        nodeList.add(new GraphAdjacencyMatrix.GraphNode("C", 2));
        nodeList.add(new GraphAdjacencyMatrix.GraphNode("D", 3));
        nodeList.add(new GraphAdjacencyMatrix.GraphNode("E", 4));

        GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(nodeList);

        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);

        System.out.print(g.toString());
    }
}
