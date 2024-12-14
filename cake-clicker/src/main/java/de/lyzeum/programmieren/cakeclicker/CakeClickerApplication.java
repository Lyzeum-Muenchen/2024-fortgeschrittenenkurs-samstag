package de.lyzeum.programmieren.cakeclicker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CakeClickerApplication extends Application {
    private GameState gameState;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CakeClickerApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Cake Clicker");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();

        CakeClickerController controller = fxmlLoader.getController();
        gameState = new GameState();
        controller.setGameState(gameState);
    }

    public static void main(String[] args) {
        launch();
    }
}