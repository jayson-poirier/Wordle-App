package application.wordle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("fxml/Wordle.fxml"));

        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setMinHeight(850);
        primaryStage.setMinWidth(850);
        primaryStage.show();
    }
}
