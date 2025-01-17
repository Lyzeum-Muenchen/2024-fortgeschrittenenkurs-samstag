package de.lyzeum.programmieren.texteditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TextEditorApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Text Editor");
        FXMLLoader fxmlLoader = new FXMLLoader(TextEditorApplication.class.getResource("text-editor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}