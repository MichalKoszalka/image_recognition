package com.example.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.neural.ImageRecognitionResult;

public class ScreensModel {

	private static ScreensModel instance;

	private File neuralNet;

	private List<File> imagesToRecognize = new ArrayList<>();

	private ImageRecognitionResult imageRecognitionResult;

	private ScreensModel() {
	}

	public static ScreensModel getInstance() {
		if(instance == null) {
			instance = new ScreensModel();
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

	public ImageRecognitionResult getImageRecognitionResult() {
		return imageRecognitionResult;
	}

	public void setImageRecognitionResult(ImageRecognitionResult imageRecognitionResult) {
		this.imageRecognitionResult = imageRecognitionResult;
	}
}
