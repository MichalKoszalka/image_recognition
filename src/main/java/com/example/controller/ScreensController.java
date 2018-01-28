package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import com.example.annotation.Controller;
import com.example.enums.Screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ScreensController extends StackPane {

	private static final String PACKAGE_NAME = "com.example";

	private static ScreensController instance;
	private Map<Screen, Node> screens = new HashMap<>();

	private ScreensController() {
		super();
		initialize();
	}

	public static ScreensController getInstance() {
		if (instance == null) {
			synchronized (ScreensController.class) {
				if (instance == null) {
					instance = new ScreensController();
				}
			}
		}
		return instance;
	}

	private void initialize() {
		Reflections reflections = new Reflections(PACKAGE_NAME);
		Set<Class<? extends ControlledScreen>> classes = reflections.getSubTypesOf(ControlledScreen.class);
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Controller.class);
		classes.stream().filter(annotatedClasses::contains).forEach(
				controllerClass -> loadScreen(controllerClass.getAnnotation(Controller.class).screen(),
						controllerClass.getAnnotation(Controller.class).path()));
		setScreen(Screen.MAIN_SCREEN);
	}

	public void addScreen(Screen name, Node screen) {
		screens.put(name, screen);
	}

	public Node getScreen(Screen name) {
		return screens.get(name);
	}

	public void loadScreen(Screen name, String resource) {
		try {
			FXMLLoader myLoader = new FXMLLoader(getClass().getClassLoader().getResource(resource));
			Parent loadedScreen = myLoader.load();
			ControlledScreen myScreenController = myLoader.getController();
			addScreen(name, loadedScreen);
			myScreenController.setScreenParent(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setScreen(Screen name) {
		if (screens.get(name) != null) {
			if (!getChildren().isEmpty()) {
				getChildren().remove(0);
				getChildren().add(0, screens.get(name));
			} else {
				getChildren().add(screens.get(name));
			}
		}
	}

	public boolean unloadScreen(Screen name) {
		return screens.remove(name) != null;
	}
}
