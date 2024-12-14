package de.lyzeum.programmieren.cakeclicker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class CakeClickerController implements Initializable {
    private GameState gameState;
    @FXML
    private Label lblCounter;
    @FXML
    private VBox vboxUpgrades;

    @FXML
    private ImageView imgCake;
    private final Image img;

    private ArrayList<UpgradePane> upgrades;
    public CakeClickerController() {
        img = new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/assets/cake.png")
                )
        );
    }

    public void onCakeClick() {
        gameState.onClick();
        updateScreen();
    }
    // Counter aktualisieren, Upgrades aktualisieren
    public void updateScreen() {
        lblCounter.setText(gameState.getCounter() + "");
        for (UpgradePane pane: upgrades) {
            pane.updatePane();
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        createUpdatePanes(); // Erst hier sind alle Upgrade bekannt
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        upgrades = new ArrayList<>();
        imgCake.setImage(img);
        imgCake.setPreserveRatio(true);
    }

    public void createUpdatePanes() {
        for (int i = 0; i < gameState.getUpgrades().length; i++) {
            UpgradePane pane = new UpgradePane(gameState, gameState.getUpgrades()[i], this);
            upgrades.add(pane);
            vboxUpgrades.getChildren().add(pane);
        }
        updateScreen();
    }
}