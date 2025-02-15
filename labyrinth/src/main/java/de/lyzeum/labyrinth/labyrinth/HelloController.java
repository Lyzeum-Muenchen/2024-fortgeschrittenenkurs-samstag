package de.lyzeum.labyrinth.labyrinth;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ConfigurationPanel configurationPanel;

    @FXML
    private Canvas canvas;

    @FXML
    private BorderPane borderPane;


    private Labyrinth l;

    public void setLabyrinth(Labyrinth l) {
        this.l = l;
        drawLabyrinth(borderPane.getWidth(), borderPane.getHeight());
    }

    private void drawLabyrinth(double borderPaneWidth, double borderPaneHeight) {
        double canvasWidth = borderPaneWidth - configurationPanel.getWidth() - 10;
        double canvasHeight = borderPaneHeight - 10;
        canvas.setWidth(canvasWidth);
        canvas.setHeight(canvasHeight);
        // Wähle tileLength, sodass alle tiles später im Canvas sichtbar sind
        double tileLength = Math.min(canvasWidth / l.getWidth(), canvasHeight / l.getHeight());
        var gc = canvas.getGraphicsContext2D();
        int width = l.getWidth();
        int height = l.getHeight();
        // lösche alten Inhalt
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0, 0 ,width * tileLength, height * tileLength);
        // Labyrinth Inhalt zeichnen
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // Vergleich mit Nachbarfeldern
                int curId = l.toIndex(i, j);
                if (i < width - 1) {
                    int neighborId = l.toIndex(i + 1, j);
                    if (!l.getGraph().hasEdge(curId, neighborId)) {
                        // Wand zeichnen
                        gc.strokeLine((i + 1) * tileLength, j * tileLength,
                                (i + 1) * tileLength, (j + 1) * tileLength);
                    }
                }
                if (j < height - 1) {
                    int neighborId = l.toIndex(i, j + 1);
                    if (!l.getGraph().hasEdge(curId, neighborId)) {
                        // Wand zeichnen
                        gc.strokeLine(i * tileLength, (j + 1) * tileLength,
                                (i + 1) * tileLength, (j + 1) * tileLength);
                    }
                }
            }
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLabyrinth(new Labyrinth(30, 20));
        // Übergebe eine Funktion an das Objekt configurationPanel
        configurationPanel.setCallbackFunction(this::setLabyrinth);
        // Beobachter hinzufügen um auf Größenänderungen zu reagieren
        borderPane.widthProperty().addListener(
            (obs, oldValue, newValue) -> {
                drawLabyrinth(
                        newValue.doubleValue(),
                        borderPane.getHeight()
                );
            }
        );
        borderPane.heightProperty().addListener(
                (obs, oldValue, newValue) -> {
                    drawLabyrinth(
                            borderPane.getWidth(),
                            newValue.doubleValue()
                    );
                }
        );



    }

}