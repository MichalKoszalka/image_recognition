package com.example.neural;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.imgrec.ImageRecognitionPlugin;

import com.example.controller.ImageRecognitionController;

public class NeuralNetImageRecognitionService implements NeuralNetImageRecognitionServiceAdapter {

	private ImageRecognitionController imageRecognitionController;

	@Override
	public ImageRecognitionResult runImageRecognitionResult(File neuralNet, List<File> imagesToRecognize) {
		NeuralNetwork neuralNetwork = NeuralNetwork.createFromFile(neuralNet);
		ImageRecognitionPlugin imageRecognitionPlugin = (ImageRecognitionPlugin) neuralNetwork
				.getPlugin(ImageRecognitionPlugin.class);
		ImageRecognitionResult recognitionResult = new ImageRecognitionResult();
			imagesToRecognize.forEach(file -> {
				try {
					recognitionResult.getProbabilityMap().put(file.getName(), imageRecognitionPlugin.recognizeImage(file));
					imageRecognitionController.increaseProgressBarValue();
				} catch (IOException e) {
					e.printStackTrace();
					imageRecognitionController.showImageProcessingError();
				}
			});
		return recognitionResult;
	}

	@Override
	public void registerImageRecognitionController(ImageRecognitionController controller) {
		imageRecognitionController = controller;
	}

}
