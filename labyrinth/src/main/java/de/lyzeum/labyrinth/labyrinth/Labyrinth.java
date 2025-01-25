package de.lyzeum.labyrinth.labyrinth;

public class Labyrinth {

    private Graph g;
    private int width;
    private int height;


    public Labyrinth() {
        createExample();
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
