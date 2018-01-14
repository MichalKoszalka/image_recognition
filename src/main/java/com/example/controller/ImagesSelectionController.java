package com.example.controller;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.annotation.Controller;
import com.example.enums.Screen;
import com.example.model.ScreensModel;

import ch.qos.logback.core.util.StringCollectionUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

@Controller(screen = Screen.IMAGES_SELECTION, path ="fxml/images_selection.fxml")
public class ImagesSelectionController extends ControlledScreen implements Initializable {

	@FXML
	private TextField pathTextField;

	private SimpleStringProperty pathNameProperty;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pathNameProperty = new SimpleStringProperty();
		pathTextField.textProperty().bind(pathNameProperty);	}

	@FXML
	public void onSelectPathClicked(Event event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose images to recognize");
		List<File> imageFiles = fileChooser.showOpenMultipleDialog(((Node)event.getTarget()).getScene().getWindow());
		if(imageFiles != null && !imageFiles.isEmpty()) {
			pathNameProperty.setValue(imageFiles.get(0).getParent());
			ScreensModel.getInstance().setImagesToRecognize(imageFiles);
		}
	}

	@FXML
	public void onBackClicked() {
		screensController.setScreen(Screen.NEURAL_NET_SELECTION);
	}

	@FXML
	public void onNextClicked() {
		screensController.setScreen(Screen.IMAGE_RECOGNITION);
	}
}
