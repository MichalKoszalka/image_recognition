package com.example.controller;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import com.example.annotation.Controller;
import com.example.enums.Screen;
import com.example.model.ScreensModel;
import com.example.neural.RecognitionResult;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Controller(screen = Screen.RESULTS, path = "fxml/results.fxml")
public class ResultsController extends ControlledScreen {

	@FXML
	private TableView<RecognitionResult> resultsTableView;

	public void initialize(URL location, ResourceBundle resources) {
		if(ScreensModel.getInstance().getImageRecognitionResult() != null) {
			resultsTableView.setItems(ScreensModel.getInstance().getImageRecognitionResult());
		}
	}

	@FXML
	public void onBackClicked() {
		screensController.setScreen(Screen.IMAGE_RECOGNITION);
	}



}
