package application.wordle;

import application.api.Dictionary;
import application.api.RandomWord;
import application.wordle.models.Word;

import java.io.IOException;
import java.util.ArrayList;

public class GameLogic {
    private Word[] words;
    public int currentIndex;
    private String wordToGuess;

    public GameLogic() {
        words = new Word[]{new Word(), new Word(), new Word(), new Word(), new Word(), new Word()};
        currentIndex = 0;

        try {
            wordToGuess = RandomWord.getRandomWord();
            System.out.println(wordToGuess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addLetter(String letter) {
        words[currentIndex].addLetter(letter);
    }

    public Word getWord(int index) {
        return words[index];
    }

    public ArrayList<String>[] getColoredKeys() {
        ArrayList[] arrayLists = new ArrayList[]{words[currentIndex - 1].goodLetters, words[currentIndex - 1].correctLetters, words[currentIndex - 1].wrongLetters};

        return arrayLists;
    }

    public String[] verifyWord() {
        try {
            if (words[currentIndex].isWordFull()) {
                if (Dictionary.verifyWordValidity(words[currentIndex].toString())) {
                    boolean isGood = words[currentIndex].verifyWord(wordToGuess);

                    if (!isGood && currentIndex == 5)
                        return new String[]{"You lost :(", "You failed to guess the word correctly within the 6 permitted tries. The word was: " + wordToGuess};
                    else if (isGood)
                        return new String[]{"You won :)", "Congratulations, you guessed the word correctly in " + (currentIndex + 1) + " tries !"};
                    else
                        currentIndex++;
                } else
                    return new String[]{"Unknown word", "The word your are trying to guess does not seem to exist in our dictionary.", "Error"};
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String[]{};
    }
}
