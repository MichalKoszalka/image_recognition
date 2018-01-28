package com.example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.annotation.Controller;
import com.example.enums.Screen;
import com.example.model.ScreensModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

@Controller(screen = Screen.NEURAL_NET_SELECTION, path = "fxml/neuralnet_selection.fxml")
public class NeuralNetSelectionController extends ControlledScreen implements Initializable {

	@FXML
	private TextField pathTextField;

	private SimpleStringProperty pathNameProperty;

	public void initialize(URL location, ResourceBundle resources) {
		pathNameProperty = new SimpleStringProperty();
		pathTextField.textProperty().bind(pathNameProperty);
	}

	@FXML
	public void onSelectPathClicked(Event event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open nnet File");
		ScreensModel.getInstance().setNeuralNet(fileChooser.showOpenDialog(((Node)event.getTarget()).getScene().getWindow()));
		if(ScreensModel.getInstance().getNeuralNet() != null) {
			pathNameProperty.setValue(ScreensModel.getInstance().getNeuralNet().getPath());
		}
	}

	@FXML
	public void onBackClicked() {
		clearPath();
		ScreensModel.getInstance().setNeuralNet(null);
		screensController.setScreen(Screen.MAIN_SCREEN);
	}

	@FXML
	public void onNextClicked() {
		clearPath();
		screensController.setScreen(Screen.IMAGES_SELECTION);
	}

	private void clearPath() {
		pathNameProperty.setValue("");
		pathTextField.clear();
	}
}
