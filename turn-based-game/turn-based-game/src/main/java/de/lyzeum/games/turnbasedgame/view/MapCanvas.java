package de.lyzeum.games.turnbasedgame.view;

import de.lyzeum.games.turnbasedgame.model.GameState;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MapCanvas extends Canvas {

    public void updateScreen(GameState gameState) {
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}
