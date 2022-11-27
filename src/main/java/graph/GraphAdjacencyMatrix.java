package graph;

import java.util.ArrayList;

public class GraphAdjacencyMatrix {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int[][] adjacencyMatrix;

    public static class GraphNode {
        public String name;
        public int index;

        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    public GraphAdjacencyMatrix(ArrayList<GraphNode> nodelist) {
        this.nodeList = nodelist;
        int n = nodelist.size();
        adjacencyMatrix = new int[n][n];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }

        s.append("\n");

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }

        return s.toString();
    }
}
