package application.wordle;

import application.wordle.controllers.MainMenuController;
import application.wordle.controllers.WordleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Loaders management
        FXMLLoader mainMenuLoader = new FXMLLoader(this.getClass().getResource("fxml/MainMenu.fxml"));
        FXMLLoader wordleLoader = new FXMLLoader(this.getClass().getResource("fxml/Wordle.fxml"));

        //Scenes management
        Scene mainMenu = new Scene(mainMenuLoader.load());
        Scene wordle = new Scene(wordleLoader.load());

        //Controllers management
        MainMenuController mainMenuController = mainMenuLoader.getController();
        WordleController wordleController = wordleLoader.getController();

        mainMenuController.setStage(primaryStage);
        mainMenuController.setScene(mainMenu);
        mainMenuController.setWordleController(wordleController);

        wordleController.setStage(primaryStage);
        wordleController.setScene(wordle);
        wordleController.setMainMenuController(mainMenuController);

        mainMenuController.mainMenu();
    }
}
