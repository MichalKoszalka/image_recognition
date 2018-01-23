package com.example;

import com.example.controller.ScreensController;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
		Parent root = ScreensController.getInstance();
		primaryStage.setTitle("Image recognition");
        primaryStage.setScene(new Scene(root));
		primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
