package de.lyzeum.games.turnbasedgame.view;

import de.lyzeum.games.turnbasedgame.model.GameCharacter;
import de.lyzeum.games.turnbasedgame.model.GameState;
import de.lyzeum.games.turnbasedgame.model.Position;
import de.lyzeum.games.turnbasedgame.model.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Set;

public class MapCanvas extends Canvas {

    private double tileLength;
    private GameState gameState;

    public MapCanvas() {
        this.setOnMousePressed(this::onMousePressed);
    }
    public void onMousePressed(MouseEvent event) {
        if (tileLength > 0 && gameState != null) {
            int tileX = (int)(event.getX() / tileLength);
            int tileY = (int)(event.getY() / tileLength);
            gameState.onTilePressed(new Position(tileX, tileY));
        }
    }

    public void updateScreen(GameState gameState) {
        this.gameState = gameState;
        GameCharacter brandon = gameState.getCharacters().getFirst();
        Set<Position> walkablePositions = gameState.getWalkablePositions(
                brandon.getCurrentPosition(),
                brandon.getStepsPerTurn()
        );
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
       for (int layer = 0; layer < 2; layer++) {
           for (int i = 0; i < gameState.getLevelWidth(); i++) {
               for (int j = 0; j < gameState.getLevelHeight(); j++) {
                   double posX = tileLength * i;
                   double posY = tileLength * j;
                   boolean isWalkablePosition = walkablePositions.contains(new Position(i, j));
                   if (layer == 0 && !isWalkablePosition) {
                       gc.setStroke(Color.BLACK);
                       gc.strokeRect(posX, posY, tileLength, tileLength);
                   } else if(layer == 1 && isWalkablePosition) {
                       gc.setStroke(Color.YELLOW);
                       gc.strokeRect(posX, posY, tileLength, tileLength);
                   }

               }
           }
       }

        for (GameCharacter character: gameState.getCharacters()) {
            double posX = character.getCurrentPosition().posX() * tileLength;
            double posY = character.getCurrentPosition().posY() * tileLength;
            gc.setFill(Color.BLUE); // TODO Textur einfügen
            gc.fillRect(posX, posY, tileLength, tileLength);
        }

        for (GameCharacter character: gameState.getEnemies()) {
            double posX = character.getCurrentPosition().posX() * tileLength;
            double posY = character.getCurrentPosition().posY() * tileLength;
            gc.setFill(Color.MEDIUMVIOLETRED); // TODO Textur einfügen
            gc.fillRect(posX, posY, tileLength, tileLength);
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
