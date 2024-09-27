package application.wordle.models;

import javafx.scene.control.Label;

import java.util.Map;

public class Word {

    private Letter[] word;
    private Map<Integer, Letter> goodLetters;
    private Map<Integer, Letter> correctLetters;
    private Map<Integer, Letter> badLetters;

    public Word() {
        word = new Letter[]{
                new Letter(),
                new Letter(),
                new Letter(),
                new Letter(),
                new Letter()
        };
    }

    public Label[] getWord() {
        return null;
    }

    public boolean verifyWord(String goodWord) {
        return false;
    }
}
