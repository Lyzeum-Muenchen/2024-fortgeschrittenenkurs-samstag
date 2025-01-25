package de.lyzeum.labyrinth.labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private boolean[][] matrix;

    public Graph(int nodeCount) {
        matrix = new boolean[nodeCount][nodeCount];
    }

    public void addEdge(int id1, int id2) {
        matrix[id1][id2] = true;
        matrix[id2][id1] = true;
    }

    public boolean hasEdge(int id1, int id2) {
        return matrix[id1][id2];
    }

    public List<Integer> getNeighbors(int curId) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (hasEdge(curId, i)) {
                results.add(i);
            }
        }
        return results;
    }
}
