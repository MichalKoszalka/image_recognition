package com.example.neural;

public class RecognitionResult {

	private  String imageName;
	private  String resultName;
	private  Double probability;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public Double getProbability() {
		return probability;
	}

	public void setProbability(Double probability) {
		this.probability = probability;
	}
}
