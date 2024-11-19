package application.wordle.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class MainMenuController {
    private Stage primaryStage;
    private Scene mainMenuScene;
    private WordleController wordleController;


    public void setStage(Stage stage) {
        primaryStage = stage;
    }

    public void setScene(Scene scene) {
        mainMenuScene = scene;
    }

    public void setWordleController(WordleController controller) {
        wordleController = controller;
    }

    public void startGame(ActionEvent event) {
        wordleController.startGame();
    }

    public void mainMenu() {
        primaryStage.hide();

        primaryStage.setScene(mainMenuScene);

        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(630);
        primaryStage.setHeight(450);
        primaryStage.setWidth(630);
        primaryStage.setTitle("Wordle Main Menu");

        primaryStage.show();
    }

    public void quit(ActionEvent event) {
        primaryStage.close();
    }
}
