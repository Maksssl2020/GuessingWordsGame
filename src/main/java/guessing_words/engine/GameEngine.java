package guessing_words.engine;

import guessing_words.models.WordToGuess;

import java.util.ArrayList;

public class GameEngine {
    private ArrayList<String> enteredWords;
    private WordToGuess wordToGuess;

    public GameEngine() {}

    public void setWordToGuess(String wordToGuess, String wordCategory) {
        this.wordToGuess = new WordToGuess(wordToGuess, wordCategory);
        enteredWords = new ArrayList<>();
    }

    public String guessTheWord(String guessWord) {
        enteredWords.add(guessWord);

        if (guessWord.equalsIgnoreCase(getEnteredWord())) {
            enteredWords.clear();
            return "Player guessed the hidden word!";
        } else {
            return "Player didn't guess the hidden word!";
        }
    }

    public ArrayList<String> getEnteredWords() {
        return enteredWords;
    }

    public WordToGuess getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(WordToGuess wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public String getEnteredWord() {
        return wordToGuess.getEnteredWord();
    }

    public String getWordCategory() {
        return wordToGuess.getWordCategory();
    }

    public String getHiddenEnteredWord() {
        return wordToGuess.getHiddenEnteredWord();
    }
}
