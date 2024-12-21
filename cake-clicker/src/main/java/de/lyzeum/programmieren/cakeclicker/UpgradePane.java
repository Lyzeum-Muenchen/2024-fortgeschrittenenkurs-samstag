package de.lyzeum.programmieren.cakeclicker;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class UpgradePane extends GridPane {
    private GameState gameState;
    private CakeClickerController controller;
    private Item item;
    private Label lblName;
    private Label lblCount;
    private Button btnUpgrade;

    public UpgradePane(GameState gameState,
                       Item item,
                       CakeClickerController controller
    ) {
        super();
        this.controller = controller;
        this.gameState = gameState;
        this.item = item;

        final var columnName = new ColumnConstraints();
        columnName.setPercentWidth(50);
        final var columnCount = new ColumnConstraints();
        columnCount.setPercentWidth(10);
        final var columnButton = new ColumnConstraints();
        columnButton.setPercentWidth(40);
        // Constraints auf das GridPane anwenden
        this.getColumnConstraints().addAll(
                columnName,
                columnCount,
                columnButton
        );
        this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(Double.MAX_VALUE);

        lblName = new Label(item.getUpgradeName());
        lblName.setFont(Font.font(20));
        lblName.setWrapText(true); // laengere Texte in mehreren zeilen anzeigen

        lblCount = new Label(item.getCount() + "");
        lblCount.setFont(Font.font(20));

        btnUpgrade = new Button(item.getUpgradeCost() + " Slices");
        btnUpgrade.setFont(Font.font(20));
        btnUpgrade.setWrapText(true);
        btnUpgrade.setMaxWidth(Double.MAX_VALUE);
        btnUpgrade.setMaxHeight(Double.MAX_VALUE);
        btnUpgrade.setOnAction(this::onButtonClick); // Verweis auf Methode

        this.add(lblName, 0, 0);
        this.add(lblCount, 1, 0);
        this.add(btnUpgrade, 2, 0);
    }
    public void onButtonClick(ActionEvent event) {
        // UpgradeCounter erhöhen
        // Counter wird verrringert
        // ClickValue und automaticClickValue wird erhöht
        // Anzeige soll sich aktualisieren
        gameState.buyUpgrade(
                item.getUpgradeCost(),
                item.getManualClickValue(),
                item.getAutomaticClickValue()
        );
        item.setCount(item.getCount() + 1);
        item.setUpgradeCost((long)(item.getUpgradeCost() * 1.05));
        btnUpgrade.setText(item.getUpgradeCost() + " Slices");
        controller.updateScreen();
    }
    public void updatePane() {
        lblCount.setText(item.getCount() + "");
        boolean isButtonDisabled = gameState.getCounter() < item.getUpgradeCost();
        btnUpgrade.setDisable(isButtonDisabled);
    }
}
