module de.lyzeum.programmieren.texteditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;


    opens de.lyzeum.programmieren.texteditor to javafx.fxml;
    exports de.lyzeum.programmieren.texteditor;
}