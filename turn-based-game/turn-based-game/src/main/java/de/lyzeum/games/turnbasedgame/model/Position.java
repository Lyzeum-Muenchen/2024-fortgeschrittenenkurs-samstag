package de.lyzeum.games.turnbasedgame.model;

public record Position(
        int posX,
        int posY
) {
    public Position move(int diffX, int diffY) {
        return new Position (
                posX + diffX,
                posY + diffY
        );
    }
}
