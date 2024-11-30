package de.lyzeum2.programmieren.cakeclicker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CakeClickerController implements Initializable {
    private GameState gameState;
    @FXML
    private Label lblCounter;
    @FXML
    private VBox vboxUpgrades;

    private ArrayList<UpgradePane> upgrades;

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
        createUpdatePanes(); // Erst hier sind alle Upgrade bekannt
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        upgrades = new ArrayList<>();
    }

    public void createUpdatePanes() {
        for (int i = 0; i < gameState.getUpgrades().length; i++) {
            UpgradePane pane = new UpgradePane(gameState, gameState.getUpgrades()[i]);
            upgrades.add(pane);
            vboxUpgrades.getChildren().add(pane);
        }
    }
}