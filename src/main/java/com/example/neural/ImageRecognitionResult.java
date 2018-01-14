package com.example.neural;

import java.util.HashMap;
import java.util.Map;

public class ImageRecognitionResult {

	private Map<String, Map<String, Double>> probabilityMap = new HashMap<>();

	public Map<String, Map<String, Double>> getProbabilityMap() {
		return probabilityMap;
	}

	public void setProbabilityMap(Map<String, Map<String, Double>> probabilityMap) {
		this.probabilityMap = probabilityMap;
	}
}
