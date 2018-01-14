package com.example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.annotation.Controller;
import com.example.enums.Screen;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

@Controller(screen = Screen.MAIN_SCREEN, path = "fxml/menu.fxml")
public class MainController extends ControlledScreen implements Initializable {

	@FXML
	public void onStartClicked() {
		screensController.setScreen(Screen.NEURAL_NET_SELECTION);
	}

	@FXML
	public void onAboutClicked() {
		screensController.setScreen(Screen.ABOUT);
	}

	@FXML
	public void onExitClicked() {
		Platform.exit();
		System.exit(0);
	}

}
