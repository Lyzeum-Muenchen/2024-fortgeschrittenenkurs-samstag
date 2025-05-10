package de.lyzeum.games.turnbasedgame.view;

import de.lyzeum.games.turnbasedgame.model.GameState;
import de.lyzeum.games.turnbasedgame.model.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MapCanvas extends Canvas {

    private double tileLength;

    public void updateScreen(GameState gameState) {
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());

        Tile[][] tiles = gameState.getTiles();
        tileLength = getTileLength(tiles.length, tiles[0].length);
        for (int i = 0; i < gameState.getLevelWidth(); i++) {
            for (int j = 0; j < gameState.getLevelHeight(); j++) {
                double posX = tileLength * i;
                double posY = tileLength * j;
                gc.setFill(getFillColor(tiles[i][j]));
                gc.fillRect(posX, posY, tileLength, tileLength);
            }
        }
        // Zeichne Ränder
        for (int i = 0; i < gameState.getLevelWidth(); i++) {
            for (int j = 0; j < gameState.getLevelHeight(); j++) {
                double posX = tileLength * i;
                double posY = tileLength * j;
                gc.setStroke(Color.BLACK);
                gc.strokeRect(posX, posY, tileLength, tileLength);
            }
        }
    }

    private Color getFillColor(Tile tile) {
        return switch(tile) {
            case Tile.WALL_BORDER_TILE -> Color.BLACK;
            case Tile.GRASS_TILE -> Color.GREEN;
        };
    }

    private double getTileLength(int levelWidth, int levelHeight) {
        return Math.min(
                this.getWidth() / levelWidth,
                this.getHeight() / levelHeight
        );
    }
}
