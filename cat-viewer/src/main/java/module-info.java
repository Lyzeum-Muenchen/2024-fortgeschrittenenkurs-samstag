module de.lyzeum.tools.catviewer {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.net.http;
	requires com.fasterxml.jackson.databind;


	opens de.lyzeum.tools.catviewer to javafx.fxml;
	exports de.lyzeum.tools.catviewer;
}