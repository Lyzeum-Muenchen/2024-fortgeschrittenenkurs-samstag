package de.lyzeum.games.turnbasedgame.model;

public enum Tile {

    WALL_BORDER_TILE(false),
    GRASS_TILE(true);

    private boolean isWalkable;
    // Enums können weitere Attribute festlegen, die zum Enum dazugehören
    Tile(boolean isWalkable) {
        this.isWalkable = isWalkable;
    }

    public boolean isWalkable() {
        return isWalkable;
    }
}
