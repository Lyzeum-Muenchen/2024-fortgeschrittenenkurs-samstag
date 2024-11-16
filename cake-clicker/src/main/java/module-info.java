module de.lyzeum2.programmieren.cakeclicker {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.lyzeum2.programmieren.cakeclicker to javafx.fxml;
    exports de.lyzeum2.programmieren.cakeclicker;
}