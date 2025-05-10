package de.lyzeum.games.turnbasedgame.view;

import de.lyzeum.games.turnbasedgame.model.GameState;
import javafx.scene.layout.StackPane;

public class MapView extends StackPane {
    private MapCanvas canvas;

    public MapView() {
        super();
        canvas = new MapCanvas();
        this.getChildren().add(canvas);
    }

    public void updateWidth(double newValue) {
        canvas.setWidth(newValue);
    }
    public void updateHeight(double newValue) {
        System.out.println(newValue);
        this.setMinHeight(Math.max(500, 0.7 * newValue));
        canvas.setHeight(0.7 * newValue);
    }

    public void updateScreen(GameState gameState) {
        canvas.updateScreen(gameState);
    }
}
