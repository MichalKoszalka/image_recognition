package com.example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public abstract class ControlledScreen implements Initializable {

	protected ScreensController screensController;

	public void setScreenParent(ScreensController screenPage) {
		screensController = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
