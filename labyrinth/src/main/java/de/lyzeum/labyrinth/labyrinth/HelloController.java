package de.lyzeum.labyrinth.labyrinth;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;

    private Labyrinth l;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int tileLength = 30;
        l = new Labyrinth(30, 20);
        var gc = canvas.getGraphicsContext2D();
        int width = l.getWidth();
        int height = l.getHeight();
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
}