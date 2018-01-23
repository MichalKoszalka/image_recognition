package com.example.neural;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
					recognitionResult.getRecognitionResults().add(createRecognitionResult(file.getName(), imageRecognitionPlugin.recognizeImage(file)));
					imageRecognitionController.increaseProgressBarValue();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		return recognitionResult;
	}

	@Override
	public void registerImageRecognitionController(ImageRecognitionController controller) {
		imageRecognitionController = controller;
	}

	private RecognitionResult createRecognitionResult(String fileName, Map<String, Double> result) {
		RecognitionResult recognitionResult = new RecognitionResult();
		recognitionResult.setImageName(fileName);
		List<Map.Entry<String, Double>> resultList = result.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(
				Collectors.toList());
		if(resultList.get(0) != null) {
			recognitionResult.setResultName(resultList.get(0).getKey());
			recognitionResult.setProbability(resultList.get(0).getValue());
		}
		return recognitionResult;
	}

}
