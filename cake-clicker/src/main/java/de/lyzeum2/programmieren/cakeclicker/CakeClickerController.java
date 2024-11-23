package de.lyzeum2.programmieren.cakeclicker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CakeClickerController {
    private GameState gameState;
    @FXML
    private Label lblCounter;

    public void onCakeClick() {
        gameState.onClick();
        updateScreen();
    }
    // Counter aktualisieren, Upgrades aktualisieren
    public void updateScreen() {
        lblCounter.setText(gameState.getCounter() + "");
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}