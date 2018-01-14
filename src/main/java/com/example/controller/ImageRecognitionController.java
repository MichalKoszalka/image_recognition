package com.example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.annotation.Controller;
import com.example.enums.Screen;
import com.example.model.ScreensModel;
import com.example.neural.NeuralNetImageRecognitionService;
import com.example.neural.NeuralNetImageRecognitionServiceAdapter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;

@Controller(screen = Screen.IMAGE_RECOGNITION, path = "fxml/image_recognition.fxml")
public class ImageRecognitionController extends ControlledScreen implements Initializable {

	@FXML
	private ProgressBar recognitionProgressBar;

	private NeuralNetImageRecognitionServiceAdapter neuralNetImageRecognitionService = new NeuralNetImageRecognitionService();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		neuralNetImageRecognitionService.registerImageRecognitionController(this);
	}

	@FXML
	public void onStartClicked() {
		neuralNetImageRecognitionService.runImageRecognitionResult(ScreensModel.getInstance().getNeuralNet(),
				ScreensModel.getInstance().getImagesToRecognize());
	}

	@FXML
	public void onBackClicked() {
		screensController.setScreen(Screen.NEURAL_NET_SELECTION);
	}

	public void increaseProgressBarValue() {
		recognitionProgressBar.setProgress(calculateProgressValue());
	}

	public void showImageProcessingError() {
		// TODO: show on toast
	}

	private double calculateProgressValue() {
		return recognitionProgressBar.getProgress() + 100  / ScreensModel.getInstance().getImagesToRecognize().size();
	}
}
