package application.wordle.models;

import java.awt.*;

public enum LetterStatus {
    GOOD(Color.GREEN),
    CORRECT(Color.ORANGE),
    BAD(Color.RED);

    LetterStatus(Color color) {
    }
}
