package com.example.neural;

import java.util.ArrayList;
import java.util.List;

public class ImageRecognitionResult {

	private List<RecognitionResult> recognitionResults = new ArrayList<>();

	public List<RecognitionResult> getRecognitionResults() {
		return recognitionResults;
	}

	public void setRecognitionResults(List<RecognitionResult> recognitionResults) {
		this.recognitionResults = recognitionResults;
	}

}
