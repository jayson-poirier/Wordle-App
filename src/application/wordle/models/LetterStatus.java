package application.wordle.models;

import javafx.scene.paint.Color;

public enum LetterStatus {
    GOOD(Color.valueOf("#73c35d")),
    CORRECT(Color.valueOf("#d0ba2b")),
    WRONG(Color.valueOf("#b54848")),
    UNTESTED(Color.valueOf("#3A3B3C")),
    EMPTY(Color.valueOf("#242424"));

    public Color color;

    LetterStatus(Color color) {
        this.color = color;
    }
}
