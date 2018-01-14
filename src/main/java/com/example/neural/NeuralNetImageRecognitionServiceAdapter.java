package com.example.neural;

import java.io.File;
import java.util.List;

import com.example.controller.ImageRecognitionController;

public interface NeuralNetImageRecognitionServiceAdapter {

	ImageRecognitionResult runImageRecognitionResult(File neuralNet, List<File> imagesToRecognize);

	void registerImageRecognitionController(ImageRecognitionController controller);

}
