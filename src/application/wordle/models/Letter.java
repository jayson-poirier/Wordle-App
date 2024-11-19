package application.wordle.models;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Letter {
    private final Paint TEXT_FILL_COLOR = Paint.valueOf("#E4E6EB");
    private final Paint EMPTY_BORDER_COLOR = Paint.valueOf("#3A3B3C");
    private final Paint UNTESTED_BORDER_COLOR = Paint.valueOf("#434445");
    private Label letterLabel;
    private LetterStatus letterStatus;

    public Letter() {
        letterLabel = new Label();

        letterLabel.setTextFill(TEXT_FILL_COLOR);
        letterLabel.setFont(new Font(48));
        letterLabel.setMaxSize(80, 80);
        letterLabel.setAlignment(Pos.CENTER);
        letterLabel.setBorder(new Border(new BorderStroke(EMPTY_BORDER_COLOR, BorderStrokeStyle.SOLID, null, BorderStroke.MEDIUM)));

        setLetterStatus(LetterStatus.EMPTY);
    }

    public int setLetter(String letter) {
        if (letter.equals("DEL")) {
            letterLabel.setText("");
            letterLabel.setBorder(new Border(new BorderStroke(EMPTY_BORDER_COLOR, BorderStrokeStyle.SOLID, null, BorderStroke.MEDIUM)));
            setLetterStatus(LetterStatus.EMPTY);
            return 0;
        } else {
            letterLabel.setText(letter);
            letterLabel.setBorder(new Border(new BorderStroke(UNTESTED_BORDER_COLOR, BorderStrokeStyle.SOLID, null, BorderStroke.MEDIUM)));
            setLetterStatus(LetterStatus.UNTESTED);
            return 1;
        }
    }

    public void setLetterStatus(LetterStatus status) {
        letterStatus = status;
        letterLabel.setBackground(new Background(new BackgroundFill(status.color, null, null)));
    }

    public LetterStatus getLetterStatus() {
        return letterStatus;
    }

    public Label getLetterLabel() {
        return letterLabel;
    }

    public String toString() {
        return letterLabel.getText();
    }
}
