package de.lyzeum.programmieren.cakeclicker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;

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
        gameState = loadGameState();
        controller.setGameState(gameState);

        stage.setOnHiding(this::onHiding); // Referenz auf Funktion
    }

    public GameState loadGameState() {
        File filePath = new File(System.getProperty("user.dir") + "/savegame.cake");
        if (filePath.exists()) {
            // SaveGame existiert --> Lade Inhalt
            try {
                FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(fis);
                GameState result = (GameState) ois.readObject(); // Cast
                ois.close();
                fis.close();
                return result;
            } catch (ClassNotFoundException | IOException e) {
                return new GameState();
            }
        } else {
            // SaveGame existiert nicht --> Erstelle neuen Spielstand
            return new GameState();
        }
    }

    public void onHiding(WindowEvent event) {
        File filePath = new File(System.getProperty("user.dir") + "/savegame.cake");
        try {
            FileOutputStream fos = new FileOutputStream(filePath.getAbsolutePath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gameState);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}