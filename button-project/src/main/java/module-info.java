module de.lyzeum2.programmieren.buttonproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.lyzeum2.programmieren.buttonproject to javafx.fxml;
    exports de.lyzeum2.programmieren.buttonproject;
}