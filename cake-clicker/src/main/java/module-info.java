module de.lyzeum.programmieren.cakeclicker {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.lyzeum.programmieren.cakeclicker to javafx.fxml;
    exports de.lyzeum.programmieren.cakeclicker;
}