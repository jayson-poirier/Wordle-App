package application.wordle.models;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Letter {
    private final String NORMAL_BACKGROUND_COLOR = " #242424";
    private final String GOOD_BACKGROUND_COLOR = " #538d4e";
    private final String CORRECT_BACKGROUND_COLOR = " ##B59F3B";
    private final String BAD_BACKGROUND_COLOR = " #3A3B3C";
    private final String TEXT_FILL_COLOR = "#E4E6EB";
    private Label letterLabel;
    private LetterStatus letterStatus;

    public Letter() {
        letterLabel = new Label();
        letterLabel.setTextFill(Paint.valueOf(TEXT_FILL_COLOR));
        letterLabel.setBackground(new Background(new BackgroundFill(Paint.valueOf(NORMAL_BACKGROUND_COLOR), null, null)));
        letterLabel.setBorder(new Border(new BorderStroke(Paint.valueOf(BAD_BACKGROUND_COLOR), BorderStrokeStyle.SOLID, null, null)));

    }

    public void setLetter (String letter) {
        letterLabel.setText(letter);
    }

    public boolean isLetterFilled() {
        return letterLabel.getText().isEmpty();
    }

    public void setLetterStatus(LetterStatus status) {
        letterStatus = status;
    }

    public LetterStatus getLetterStatus() {
        return letterStatus;
    }
}
