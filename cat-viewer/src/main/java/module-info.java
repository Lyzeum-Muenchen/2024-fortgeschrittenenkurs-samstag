module de.lyzeum.tools.catviewer {
	requires javafx.controls;
	requires javafx.fxml;


	opens de.lyzeum.tools.catviewer to javafx.fxml;
	exports de.lyzeum.tools.catviewer;
}