package de.lyzeum.games.turnbasedgame.model;

public class GameState {
    private Tile[][] tiles;
    // Enemies
    // characters

    public GameState(int levelWidth, int levelHeight) {
        initMap(levelWidth, levelHeight);
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
                if (i == 0
                        || i == levelWidth - 1
                        || j == 0
                        || j == levelHeight - 1
                        || Math.random() < 0.01
                ) {
                    // Falls Randfeld, setze nicht begehbares Feld
                    tiles[i][j] = Tile.WALL_BORDER_TILE;
                } else {
                    tiles[i][j] = Tile.GRASS_TILE;
                }
            }
        }


    }
}
