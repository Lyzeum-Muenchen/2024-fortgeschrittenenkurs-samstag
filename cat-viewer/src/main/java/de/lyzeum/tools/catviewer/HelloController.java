package de.lyzeum.tools.catviewer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
	@FXML
	private ToggleGroup groupTag;

	@FXML
	private ImageView imageView;
	@FXML
	private Label lblError;

	private final String baseUrl = "https://cataas.com/cat";
	private Image image;

	public void onLoadImageClick() {
		final RadioButton selectedButton =
				(RadioButton) groupTag.getSelectedToggle();
		final String tag = selectedButton.getText()
				.replace(" ", "%20"); // ersetze Leerzeichen in der URL

		final String url = (tag.equals("Random"))
				? baseUrl
				: baseUrl + "/" + tag;
		loadImage(url);
	}

	private void loadImage(String url) {
		image = new Image(url, false);
		if (image.getException() == null) {
			imageView.setImage(image);
			lblError.setText("");
		} else {
			final String errMsg =
					"Cat not found! "
							+ image.getException().getMessage();
			lblError.setText(errMsg);
		}
	}
}