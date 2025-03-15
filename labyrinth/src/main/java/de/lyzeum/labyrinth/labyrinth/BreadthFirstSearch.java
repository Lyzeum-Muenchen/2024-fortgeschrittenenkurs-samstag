package de.lyzeum.labyrinth.labyrinth;

import java.util.*;

// Breitensuche
// BFS = breadth-first search
public class BreadthFirstSearch {
    private Graph g;
    private int startIndex;
    private int destIndex;
    private List<Integer> solutionPath;
    private List<Integer> visitedNodes;

    public BreadthFirstSearch(
            final Graph g,
            final int startIndex,
            final int destIndex
    ) {
        this.g = g;
        this.startIndex = startIndex;
        this.destIndex = destIndex;
        // Algorithmus Anwendung
        // Schlüssel-Wert-Paare
        HashMap<Integer, Integer> predecessors = new HashMap<>();
        // Besuchte Knoten
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> nodesToProcess = new LinkedList<>();
        // offer(): Werfe Element ganz hinten in die Warteschlange
        nodesToProcess.offer(startIndex); // Starte mit diesem Element
        visitedNodes.add(startIndex);

        while(!nodesToProcess.isEmpty()) {
            // entnehme das vorderste Element aus der Warteschlange
            int currentNode = nodesToProcess.poll();
            // ist currentNode das Zielfeld
            if (currentNode == destIndex) {
                break; // baue gleich Pfad nach
            }
            // ermittle Nachbarn
            List<Integer> neighbors = g.getNeighbors(currentNode);
            for (int neighbor: neighbors) {
                // füge unbesuchte Felder der Queue hinzu
                if (!visitedNodes.contains(neighbor)) {
                    // markiere Feld als "besucht"
                    visitedNodes.add(neighbor);
                    // setze Vorgänger-Relation
                    predecessors.put(neighbor, currentNode);
                    // füge Wert der Warteschlange hinzu
                    nodesToProcess.offer(neighbor);
                }
            }
        }
        // Baue Pfad rückwärts zusammen
        List<Integer> reverseSolutionPath = new ArrayList<>();
        int currentNode = destIndex;
        // besuche Elemente mithilfe der Vorgänger-Relation
        while(currentNode != startIndex) {
            reverseSolutionPath.add(currentNode);
            currentNode = predecessors.get(currentNode);
        }
        reverseSolutionPath.add(startIndex);
        solutionPath = reverseSolutionPath.reversed(); // drehe Reihenfolge um
    }

    public List<Integer> getSolutionPath() {
        return solutionPath;
    }
}
