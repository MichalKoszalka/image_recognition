package com.example.controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import com.example.annotation.Controller;
import com.example.enums.Screen;
import com.example.model.ScreensModel;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

@Controller(screen = Screen.RESULTS, path = "fxml/results.fxml")
public class ResultsController extends ControlledScreen {

	@FXML
	TableView<Map.Entry<String, Map<String, Double>>> resultsTableView;

	public void initialize(URL location, ResourceBundle resources) {
		resultsTableView.getItems().addAll(ScreensModel.getInstance().getImageRecognitionResult().getProbabilityMap().entrySet());
	}

	@FXML
	public void onBackClicked() {
		screensController.setScreen(Screen.IMAGE_RECOGNITION);
	}



}
