package application.wordle.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialoguesUtils {
    public static Optional<ButtonType> endGame(String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.NONE, contentText + "\n\nDo you wish to play another game ?", ButtonType.YES, ButtonType.NO);

        alert.setHeaderText(headerText);
        alert.setTitle("Wordle Game");

        return alert.showAndWait();
    }

    public static Optional<ButtonType> error(String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.NONE, contentText, ButtonType.OK);

        alert.setHeaderText(headerText);
        alert.setTitle("Wordle Game");

        return alert.showAndWait();
    }
}
