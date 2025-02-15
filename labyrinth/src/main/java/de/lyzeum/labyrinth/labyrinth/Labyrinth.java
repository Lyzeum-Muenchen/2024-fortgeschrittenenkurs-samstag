package de.lyzeum.labyrinth.labyrinth;

import java.util.*;

public class Labyrinth {

    private Graph g;
    private int width;
    private int height;


    public Labyrinth() {
        createExample();
    }

    public Labyrinth(int width, int height) {
        this(width, height, new Random().nextLong());
    }

    public Labyrinth(int width, int height, long seed) {
        this.width = width;
        this.height = height;
        g = new Graph(width * height);
        boolean[] visited = new boolean[width * height];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;
        Random r = new Random(seed); // Zufallszahlengenerator erstellen

        while(!stack.isEmpty()) {
            // finde unbesuchte Nachbarfelder
            int curNode = stack.peek();
            int[] diffX = new int[]{0, 0, -1, 1};
            int[] diffY = new int[]{-1, 1, 0, 0};
            List<Integer> neighbors = new ArrayList<>();
            int curX = indexToX(curNode); // Koordinaten des aktuellen Knoten
            int curY = indexToY(curNode);
            for (int i = 0; i < 4; i++) {
                int newX = curX + diffX[i]; // Koordinaten des Nachbarn
                int newY = curY + diffY[i];
                int newIndex = toIndex(newX, newY);
                if (isInBounds(newX, newY) && !visited[newIndex]) {
                    neighbors.add(newIndex);
                }
            }
            // Kandidaten aussuchen
            if (!neighbors.isEmpty()) {
                int next = r.nextInt(neighbors.size());
                // Stack mit neuem Wert befüllen, Kante setzen und visited aktualisieren
                g.addEdge(curNode, neighbors.get(next));
                visited[neighbors.get(next)] = true;
                stack.push(neighbors.get(next));
            }else {
                stack.pop();
            }
        }
    }

    public boolean isInBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }


    private void createExample() {
        g = new Graph(8);
        g.addEdge(0, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 3);
        width = 4;
        height = 2;
    }

    public int toIndex(int x, int y) {
        return x + y * width;
    }

    public int indexToX(int index) {
        return index % width;
    }

    public int indexToY(int index) {
        return index / width;
    }

    public Graph getGraph() {
        return g;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
