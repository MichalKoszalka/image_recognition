package com.example.controller;

import com.example.annotation.Controller;
import com.example.enums.Screen;

import javafx.fxml.FXML;

@Controller(screen = Screen.ABOUT, path = "fxml/about.fxml")
public class AboutController extends ControlledScreen {

	@FXML
	public void onBackClicked() {
		screensController.setScreen(Screen.MAIN_SCREEN);
	}

}
