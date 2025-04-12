package de.lyzeum.games.turnbasedgame.view;

import de.lyzeum.games.turnbasedgame.model.GameState;
import javafx.scene.layout.StackPane;

public class MapView extends StackPane {
    private MapCanvas canvas;

    public MapView() {
        super();
        canvas = new MapCanvas();
    }

    public void updateWidth(double newValue) {
        canvas.setWidth(newValue);
    }
    public void updateHeight(double newValue) {
        canvas.setHeight(newValue);
    }

    public void updateScreen(GameState gameState) {
        canvas.updateScreen(gameState);
    }
}
