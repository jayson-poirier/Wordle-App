package application.wordle.controllers;

import application.wordle.GameLogic;
import application.wordle.models.LetterStatus;
import application.wordle.utils.DialoguesUtils;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordleController {
    private Stage primaryStage;
    private Scene wordleScene;
    private MainMenuController mainMenuController;
    private GameLogic gameLogic;
    private Map<String, Button> keyboardMap;

    @FXML
    private VBox keyboard;
    @FXML
    private GridPane wordGrid;


    public void setStage(Stage stage) {
        primaryStage = stage;
    }

    public void setScene(Scene scene) {
        wordleScene = scene;
    }

    public void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
    }

    public void startGame() {
        primaryStage.hide();

        gameLogic = new GameLogic();
        initializeGrid();
        createKeyboardMap();

        primaryStage.setScene(wordleScene);
        primaryStage.setMinHeight(880);
        primaryStage.setMinWidth(830);
        primaryStage.setTitle("Wordle Game");
        primaryStage.requestFocus();
        primaryStage.show();
    }

    private void createKeyboardMap() {
        keyboardMap = new HashMap<>();

        for (Node row : keyboard.getChildren()) {
            for (Node key : ((HBox) row).getChildren()) {
                keyboardMap.put(((Button) key).getText(), (Button) key);
            }
        }
    }

    private void initializeGrid() {
        wordGrid.getChildren().clear();

        for (int i = 0; i < 6; i++) {
            wordGrid.addRow(i, gameLogic.getWord(i).getLabels());
        }
    }

    public void mainMenu() {
        mainMenuController.mainMenu();
    }

    public void writeLetter(MouseEvent event) {
        gameLogic.addLetter(((Button) event.getSource()).getText());
    }

    public void verifyWord(MouseEvent event) {
        verifyWord();
    }

    public void verifyWord() {
        String[] response = gameLogic.verifyWord();
        if (response.length == 3) {
            DialoguesUtils.error(response[0], response[1]);
        } else if (response.length != 0)
            if (DialoguesUtils.endGame(response[0], response[1]).get() == ButtonType.YES)
                startGame();
            else
                mainMenu();
        if (gameLogic.currentIndex != 0) {
            colorKeyboardKeys(gameLogic.getColoredKeys());
        }
    }

    private void colorKeyboardKeys(ArrayList<String>[] coloredKeys) {
        for (String letter : coloredKeys[0]) {
            keyboardMap.get(letter).setBackground(new Background(new BackgroundFill(LetterStatus.GOOD.color, null, null)));
        }
        for (String letter : coloredKeys[1]) {
            keyboardMap.get(letter).setBackground(new Background(new BackgroundFill(LetterStatus.CORRECT.color, null, null)));
        }
        for (String letter : coloredKeys[2]) {
            keyboardMap.get(letter).setBackground(new Background(new BackgroundFill(LetterStatus.WRONG.color, null, null)));
        }
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode().isLetterKey()) {
            gameLogic.addLetter(keyEvent.getText().toUpperCase());
            keyEvent.consume();
        } else if (keyEvent.getCode() == KeyCode.DELETE || keyEvent.getCode() == KeyCode.BACK_SPACE) {
            gameLogic.addLetter("DEL");
            keyEvent.consume();
        } else if (keyEvent.getCode() == KeyCode.ENTER) {
            verifyWord();
            keyEvent.consume();
        } else
            keyEvent.consume();
    }
}
