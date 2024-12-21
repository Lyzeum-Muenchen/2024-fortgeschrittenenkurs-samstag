package de.lyzeum.programmieren.cakeclicker;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class TextPane extends Pane {

    private Text[] texts;
    private int index;

    public TextPane() {
        this.setPickOnBounds(false);
        texts = new Text[20];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = new Text();
            texts[i].setPickOnBounds(false);
            texts[i].setMouseTransparent(true);
            texts[i].setFont(Font.font(20));
            texts[i].setFill(Color.GREEN);
            texts[i].setVisible(false);
        }
        this.getChildren().addAll(texts);
    }

    // Text einblenden
    public void showTextWithTransition(String text, double posX, double posY) {
        texts[index].setText(text);
        texts[index].setVisible(true);

        texts[index].setLayoutX(posX - texts[index].getLayoutBounds().getWidth()/2);
        texts[index].setLayoutY(posY);
        // Positionsänderung
        TranslateTransition tt = new TranslateTransition(Duration.millis(500));
        tt.setFromY(0);
        tt.setToY(-100);
        tt.setCycleCount(1);
        tt.setNode(texts[index]);
        tt.play();
        // Verschwinden vom Text
        FadeTransition fd = new FadeTransition(Duration.millis(500));
        fd.setFromValue(1.0);
        fd.setToValue(0.0);
        fd.setCycleCount(1);
        fd.setNode(texts[index]);
        fd.play();

        index = (index + 1) % texts.length;
    }
}
