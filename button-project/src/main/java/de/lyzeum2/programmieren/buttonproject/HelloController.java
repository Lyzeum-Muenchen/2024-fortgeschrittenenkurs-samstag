package de.lyzeum2.programmieren.buttonproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class HelloController {
    private int clicks;
    private int clickValue = 1;

    @FXML
    private ProgressBar prgClicks;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnUpgrade;


    public void onButtonClick() {
        clicks += clickValue;
        updateState();
    }
    public void updateState() {
        lblInfo.setText("Clicks: " + clicks);
        prgClicks.setProgress(Math.min(1, clicks / 100.0));
        btnUpgrade.setDisable(clicks < 100);
    }
    public void onUpgradeButtonClick() {
        clicks -= 100;
        clickValue++;
        updateState();
    }
}