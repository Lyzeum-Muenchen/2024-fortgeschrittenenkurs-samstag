package de.lyzeum.games.turnbasedgame.model;

import java.util.*;
import java.util.stream.Collectors;

public class GameState {
    private Tile[][] tiles;
    private List<GameCharacter> characters;
    // Enemies
    private List<GameCharacter> enemies;

    public GameState(int levelWidth, int levelHeight) {
        initMap(levelWidth, levelHeight);

        characters = List.of(new Brandon(new Position(1, 1), true));
        spawnEnemies();
    }

    private void spawnEnemies() {
        // Felder mit x>=10 und y>=10 auswählen
        List<Position> candidates = new ArrayList<>();
        for (int i = 10; i < getLevelWidth(); i++) {
            for (int j = 10; j < getLevelHeight(); j++) {
                if (tiles[i][j].isWalkable()) {
                    candidates.add(new Position(i, j));
                }
            }
        }
        Random r = new Random();
        enemies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int nextIndex = r.nextInt(candidates.size());
            enemies.add(new Brandon(candidates.get(nextIndex), false));
            candidates.remove(nextIndex);
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getLevelWidth() {
        return tiles.length;
    }

    public int getLevelHeight() {
        return tiles[0].length;
    }

    private void initMap(int levelWidth, int levelHeight) {
        tiles =  new Tile[levelWidth][levelHeight]; // array initialisieren
        // Einzelfelder initialisieren
        for(int i = 0; i < levelWidth; i++) {
            for (int j = 0; j < levelHeight; j++) {
                if (i >= 1 && i <= 4 && j >= 1 && j <= 4) {
                    tiles[i][j] = Tile.GRASS_TILE; // Spawnbereich
                }else if (i == 0
                        || i == levelWidth - 1
                        || j == 0
                        || j == levelHeight - 1
                        || Math.random() < 0.1
                ) {
                    // Falls Randfeld, setze nicht begehbares Feld
                    tiles[i][j] = Tile.WALL_BORDER_TILE;
                } else {
                    tiles[i][j] = Tile.GRASS_TILE;
                }
            }
        }
    }

    public List<GameCharacter> getCharacters() {
        return characters;
    }

    public List<GameCharacter> getEnemies() {
        return enemies;
    }

    public Set<Position> getNeighbors(Position curPos) {
        Set<Position> result = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextX = curPos.posX() + i;
                int nextY = curPos.posY() + j;
                if (nextX >= 0 && nextX < getLevelWidth() && nextY >= 0
                && nextY < getLevelHeight()) {
                    result.add(new Position(nextX, nextY));
                }
            }
        }
        return result;
    }

    public Set<Position> getWalkablePositions(Position startPos, int distance) {
        Set<Position> result = new HashSet<>(); // Ergebnisse mit erreichbaren Feldern
        Set<Position> toProcess = new HashSet<>();
        toProcess.add(startPos);
        int remainingDistance = distance;
        while(!toProcess.isEmpty() && remainingDistance >= 0) {
            Set<Position> nextToProcess = new HashSet<>();
            for (Position p: toProcess) {
                // Berchne für jede Position alle besuchbaren Nachbarn
                result.add(p);
                for (Position nextPos: getNeighbors(p)) {
                    if (getTiles()[nextPos.posX()][nextPos.posY()].isWalkable()
                    && !result.contains(nextPos)) {
                        nextToProcess.add(nextPos);
                    }
                }
            }
            // Aktualisierung der zu bearbeitenden Positionen
            remainingDistance--;
            toProcess = nextToProcess;
        }
        // Positionen von eigenen Charakteren ohne Startposition aus Ergebnis entfernen
        // List -> Stream<GameCharacter> -> Stream<Position> -> Set<Position>
        Set<Position> alliedPositions = characters.stream()
                .map(character -> character.getCurrentPosition())
                .collect(Collectors.toSet());
        Set<Position> enemyPositions = enemies.stream()
                .map(character -> character.getCurrentPosition())
                .collect(Collectors.toSet());
        result.removeAll(alliedPositions);
        result.removeAll(enemyPositions);
        return result;
    }

    public void onTilePressed(Position position) {
        // walkablePositions ermitteln
        Position startPos = characters.getFirst().getCurrentPosition();
        int stepsPerTurn = characters.getFirst().getStepsPerTurn();
        Set<Position> walkablePos = getWalkablePositions(startPos, stepsPerTurn);
        // Check ob ausgewählte Position im Set liegt
        if (walkablePos.contains(position)) {
            // Bewegung durchführen, falls Zug erlaubt ist
            characters.getFirst().currentPosition = position;
        }

    }
}
