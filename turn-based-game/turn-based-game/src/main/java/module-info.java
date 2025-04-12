module de.lyzeum.games.turnbasedgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.lyzeum.games.turnbasedgame to javafx.fxml;
    exports de.lyzeum.games.turnbasedgame;

    opens de.lyzeum.games.turnbasedgame.model to javafx.fxml;
    exports de.lyzeum.games.turnbasedgame.model;

    opens de.lyzeum.games.turnbasedgame.view to javafx.fxml;
    exports de.lyzeum.games.turnbasedgame.view;
}