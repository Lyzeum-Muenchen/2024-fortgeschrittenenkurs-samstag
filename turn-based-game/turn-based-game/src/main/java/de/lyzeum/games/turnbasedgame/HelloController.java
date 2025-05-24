package de.lyzeum.games.turnbasedgame;

import de.lyzeum.games.turnbasedgame.model.GameState;
import de.lyzeum.games.turnbasedgame.view.MapView;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private MapView mapView;
    private GameState gameState = new GameState(40, 20);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mapView.widthProperty().addListener(
                (obs,
                 oldVal,
                 newVal
                ) -> {
                    mapView.updateWidth(newVal.doubleValue());
                    updateScreen();
                }
        );
        mapView.heightProperty().addListener(
                (obs,
                 oldVal,
                 newVal
                ) -> {
                    mapView.updateHeight(newVal.doubleValue());
                    updateScreen();
                }
        );
        // Gameloop initialisieren
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                updateScreen();
            }
        }.start();
    }

    public void updateScreen() {
        mapView.updateScreen(gameState);
    }
}