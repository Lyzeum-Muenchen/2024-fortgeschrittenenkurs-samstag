package de.lyzeum.programmieren.cakeclicker;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

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

    @FXML
    private TextPane textPane;

    private Timeline tlCakeAnimation;
    private Timeline tlAutomaticClick;

    private ArrayList<UpgradePane> upgrades;
    public CakeClickerController() {
        img = new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/assets/cake.png")
                )
        );
    }

    public void onCakeClick(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            gameState.onClick();
            // Größe des Kuchens ändern
            double nextSize = Math.min(imgCake.getFitWidth() * 1.05, 640);
            imgCake.setFitWidth(nextSize);
            imgCake.setFitHeight(nextSize);
            updateScreen();
            String textToShow = "+" + gameState.getClickValue();
            // Setze Text auf korrekte Koordinate abhängig von Kuchenpos. und Mauspos.
            double posX = event.getX() + imgCake.getLayoutX();
            double posY = event.getY() + imgCake.getLayoutY();
            textPane.showTextWithTransition(textToShow, posX, posY);
        }

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
        EventHandler<ActionEvent> eventCake = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Kuchen um 1% verkleinern
                double nextSize = Math.max(512, imgCake.getFitWidth() * 0.995);
                imgCake.setFitWidth(nextSize);
                imgCake.setFitHeight(nextSize);
            }
        };
        KeyFrame kfCake = new KeyFrame(
                Duration.millis(15),
                "cakeAnimation",
                eventCake
        );

        tlCakeAnimation = new Timeline(kfCake);
        // spiele Animation unendlich lange ab
        tlCakeAnimation.setCycleCount(Animation.INDEFINITE);
        tlCakeAnimation.play();

        EventHandler<ActionEvent> eventAutomaticClick = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameState.onAutomaticClick();
                updateScreen();
            }
        };
        KeyFrame kfAutomaticClick = new KeyFrame(
                Duration.seconds(1),
                "kfAutomaticClick",
                eventAutomaticClick
        );
        tlAutomaticClick = new Timeline(kfAutomaticClick);
        tlAutomaticClick.setCycleCount(Animation.INDEFINITE);
        tlAutomaticClick.play();
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