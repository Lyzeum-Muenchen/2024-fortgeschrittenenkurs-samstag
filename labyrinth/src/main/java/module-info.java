module de.lyzeum.labyrinth.labyrinth {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;


    opens de.lyzeum.labyrinth.labyrinth to javafx.fxml;
    exports de.lyzeum.labyrinth.labyrinth;
}