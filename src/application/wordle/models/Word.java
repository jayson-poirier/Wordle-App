package application.wordle.models;

import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashMap;

public class Word {
    private Letter[] word;
    public ArrayList<String> goodLetters = new ArrayList<>();
    public ArrayList<String> correctLetters = new ArrayList<>();
    public ArrayList<String> wrongLetters = new ArrayList<>();
    ;
    private int currentIndex = 0;
    private int wordLength;

    public Word() {
        this(5);
    }

    public Word(int length) {
        word = new Letter[length];

        for (int i = 0; i < length; i++) {
            word[i] = new Letter();
        }

        wordLength = length;
    }

    public Label[] getLabels() {
        Label[] labelWord = new Label[wordLength];

        for (int i = 0; i < 5; i++) {
            labelWord[i] = word[i].getLetterLabel();
        }

        return labelWord;
    }

    public void addLetter(String letter) {
        if ((letter.equals("DEL") && currentIndex >= 5) || (letter.equals("DEL") && currentIndex > 0)) {
            currentIndex--;
            currentIndex += word[currentIndex].setLetter(letter);
        } else if (currentIndex < 5)
            currentIndex += word[currentIndex].setLetter(letter);

    }

    public boolean verifyWord(String goodWord) {
        boolean isGood = true;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < wordLength; i++) {
            if (word[i].toString().equals(goodWord.charAt(i) + "")) {
                word[i].setLetterStatus(LetterStatus.GOOD);
                goodLetters.add(word[i].toString());
            } else {
                if (map.containsKey(goodWord.charAt(i) + ""))
                    map.put(goodWord.charAt(i) + "", map.get(goodWord.charAt(i) + "") + 1);
                else
                    map.put(goodWord.charAt(i) + "", 1);
            }
        }

        for (int i = 0; i < wordLength; i++) {
            for (int j = 0; j < wordLength; j++) {
                if (!map.containsKey(goodWord.charAt(i) + ""))
                    break;
                if (word[j].getLetterStatus() == LetterStatus.UNTESTED && (goodWord.charAt(i) + "").equals(word[j].toString())) {
                    word[j].setLetterStatus(LetterStatus.CORRECT);
                    if (!goodLetters.contains(word[j].toString()))
                        correctLetters.add(word[j].toString());
                    map.put(goodWord.charAt(i) + "", map.get(goodWord.charAt(i) + "") - 1);
                    isGood = false;
                    break;
                }
            }
        }

        for (Letter letter : word) {
            if (letter.getLetterStatus() == LetterStatus.UNTESTED) {
                letter.setLetterStatus(LetterStatus.WRONG);
                isGood = false;
                if (!goodLetters.contains(letter.toString()) && !correctLetters.contains(letter.toString()))
                    wrongLetters.add(letter.toString());
            }
        }
        return isGood;
    }

    public boolean isWordFull() {
        StringBuilder str = new StringBuilder();

        for (Letter letter : word) {
            str.append(letter.toString());
        }
        return str.length() == wordLength;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Letter letter : word)
            str.append(letter.toString());

        return str.toString();
    }
}
