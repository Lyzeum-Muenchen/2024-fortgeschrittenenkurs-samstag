package de.lyzeum.labyrinth.labyrinth;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.function.Consumer;

public class ConfigurationPanel extends VBox {
    @FXML
    private Spinner<Integer> spinnerWidth;
    @FXML
    private Spinner<Integer> spinnerHeight;

    // Erwartet ein Labyrinth als Eingabeparameter und hat Rückgabetyp "void"
    private Consumer<Labyrinth> callbackFunction;

    public ConfigurationPanel() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource("configuration_panel.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCallbackFunction(Consumer<Labyrinth> callbackFunction) {
        this.callbackFunction = callbackFunction;
    }

    public void onGenerateClick() {
        int width = spinnerWidth.getValue();
        int height = spinnerHeight.getValue();
        Labyrinth labyrinth = new Labyrinth(width, height);
        // Benutze Callbackfunktion
        callbackFunction.accept(labyrinth);
    }
}
