package de.lyzeum.labyrinth.labyrinth;

import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ConfigurationPanel configurationPanel;

    @FXML
    private Canvas canvas;

    @FXML
    private BorderPane borderPane;


    private Labyrinth l;
    private double tileLength;
    private List<Integer> solutionPath = List.of();

    // Werte sind entweder leer oder beinhalten Informationen
    private Optional<Integer> startTileId = Optional.empty();
    private Optional<Integer> destTileId = Optional.empty();

    public void setLabyrinth(Labyrinth l) {
        this.l = l;
        this.solutionPath = List.of();
        this.startTileId = Optional.empty();
        this.destTileId = Optional.empty();
        drawLabyrinth(borderPane.getWidth(), borderPane.getHeight());
    }

    private void drawLabyrinth(double borderPaneWidth, double borderPaneHeight) {
        double canvasWidth = borderPaneWidth - configurationPanel.getWidth() - 10;
        double canvasHeight = borderPaneHeight - 10;

        // Wähle tileLength, sodass alle tiles später im Canvas sichtbar sind
        tileLength = Math.min(canvasWidth / l.getWidth(), canvasHeight / l.getHeight());
        // Wähle Canvasgröße abhängig von tileLength
        canvas.setWidth(tileLength * l.getWidth());
        canvas.setHeight(tileLength * l.getHeight());

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
                // falls startTileId existiert und gleich curId ist
                if (startTileId.map(id -> id == curId).orElse(false)) {
                    gc.setFill(Color.GREEN);
                    gc.fillRect(i * tileLength, j * tileLength, tileLength, tileLength);
                } else if (destTileId.isPresent() && destTileId.get() == curId) {
                    // andere Schreibweise für destTileId
                    gc.setFill(Color.RED);
                    gc.fillRect(i * tileLength, j * tileLength, tileLength, tileLength);
                } else if(solutionPath.contains(curId)) {
                    gc.setFill(Color.GRAY);
                    gc.fillRect(i * tileLength, j * tileLength, tileLength, tileLength);
                }

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
        configurationPanel.setSaveScreenshotFunction(this::saveScreenshot);
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

    public void saveScreenshot() {
        // Bild und Dateipfad vorbereiten
        Image image = canvas.snapshot(null, null);
        // Füge Zeitstempel zu Dateinamen hinzu
        String filename = Instant.now()
                .truncatedTo( ChronoUnit.SECONDS )
                .toString()
                .replace( ":" , "" ) + ".jpg";
        String filePath = System.getProperty("user.dir") + "/" + filename;
        BufferedImage imageToWrite = new BufferedImage(
                (int) (canvas.getWidth() <= 0 ? 800 : canvas.getWidth()),
                (int) (canvas.getHeight() <= 0 ? 600 : canvas.getHeight()),
                BufferedImage.TYPE_INT_RGB
        );
        System.out.println("Save file to " + filePath);
        imageToWrite = SwingFXUtils.fromFXImage(image, imageToWrite);
        // Bild ins Dateisystem schreiben
        try {
            ImageIO.write(imageToWrite, "jpeg", new File(filePath));
        } catch (IOException e) {
            System.err.println("Image could not be saved!");
        }
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
        int tileX = (int)(mouseEvent.getX() / tileLength);
        int tileY = (int)(mouseEvent.getY() / tileLength);
        int tileId = l.toIndex(tileX, tileY);
        // Füge Wert in Optional ein
        if (startTileId.isEmpty() || destTileId.isPresent()) {
            startTileId = Optional.of(tileId);
            destTileId = Optional.empty();
            solutionPath = List.of(); // setze Pfad zurück
        } else {
            destTileId = Optional.of(tileId);
            // führe Wegsuche aus
            BreadthFirstSearch bfs = new BreadthFirstSearch(
                    l.getGraph(),
                    startTileId.get(),
                    destTileId.get()
            );
            solutionPath = bfs.getSolutionPath();
        }
        drawLabyrinth(borderPane.getWidth(), borderPane.getHeight());
    }
}