package de.lyzeum.tools.catviewer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.util.Collections;
import java.util.List;

public class HelloController {
	@FXML
	private ToggleGroup groupTag;

	@FXML
	private ImageView imageView;
	@FXML
	private Label lblError;
	@FXML
	private FlowPane flowPaneTags;

	private final String baseUrl = "https://cataas.com/cat";
	private CatTagWebClient webClient = new CatTagWebClient();
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

	public void onRefreshTagsClick() {
		List<String> results = webClient.fetchTags();
		flowPaneTags.getChildren().clear();
		RadioButton radioButtonRandom = new RadioButton("Random");
		radioButtonRandom.setToggleGroup(groupTag);
		radioButtonRandom.setSelected(true);
		flowPaneTags.getChildren().add(radioButtonRandom);

		Collections
				.shuffle(results);
		results
				.stream()
				.limit(20)
				.forEach(tagName -> {
			RadioButton button =  new RadioButton(tagName);
			button.setToggleGroup(groupTag);
			flowPaneTags.getChildren().add(button);
		});
	}
}