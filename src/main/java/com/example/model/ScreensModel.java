package com.example.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.neural.ImageRecognitionResult;
import com.example.neural.RecognitionResult;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ScreensModel {

	private static ScreensModel instance;

	private File neuralNet;

	private List<File> imagesToRecognize = new ArrayList<>();

	private ObservableList<RecognitionResult> imageRecognitionResult = FXCollections.observableArrayList();

	private ScreensModel() {
	}

	public static ScreensModel getInstance() {
		if (instance == null) {
			synchronized (ScreensModel.class) {
				if (instance == null) {
					instance = new ScreensModel();
				}
			}
		}
		return instance;
	}

	public File getNeuralNet() {
		return neuralNet;
	}

	public void setNeuralNet(File neuralNet) {
		this.neuralNet = neuralNet;
	}

	public List<File> getImagesToRecognize() {
		return imagesToRecognize;
	}

	public void setImagesToRecognize(List<File> imagesToRecognize) {
		this.imagesToRecognize = imagesToRecognize;
	}

	public ObservableList<RecognitionResult> getImageRecognitionResult() {
		return imageRecognitionResult;
	}

	public void setImageRecognitionResult(ObservableList<RecognitionResult> imageRecognitionResult) {
		this.imageRecognitionResult = imageRecognitionResult;
	}
}
