package guessing_words.engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GuessingWordsEngineTest {
    private GameEngine gameEngine;

    @BeforeEach
    void setUp() {
        gameEngine = new GameEngine();
    }

    @Test
    void testSetGameWordToGuess() {
        String wordToGuess = "Dog";
        String wordCategory = "Animal";

        gameEngine.setWordToGuess(wordToGuess, wordCategory);
        assertThat(gameEngine.getEnteredWord()).isEqualTo(wordToGuess);
        assertThat(gameEngine.getWordCategory()).isEqualTo(wordCategory);
    }

    @Test
    void testEnterCorrectWordToGuess() {
        String wordToGuess = "Dog";
        String wordCategory = "Animal";

        gameEngine.setWordToGuess(wordToGuess, wordCategory);
        String resultMessage = gameEngine.guessTheWord("dog");
        assertThat(resultMessage).isEqualTo("Player guessed the hidden word!");
    }

    @Test
    void testEnterIncorrectWordToGuess() {
        String wordToGuess = "Dog";
        String wordCategory = "Animal";

        gameEngine.setWordToGuess(wordToGuess, wordCategory);
        String resultMessage = gameEngine.guessTheWord("cat");
        assertThat(resultMessage).isEqualTo("Player didn't guess the hidden word!");
    }

    @Test
    void testGettingEnteredPlayerWordsHistory() {
        String wordToGuess = "Dog";
        String wordCategory = "Animal";

        gameEngine.setWordToGuess(wordToGuess, wordCategory);
        gameEngine.guessTheWord("Cat");
        gameEngine.guessTheWord("Horse");
        gameEngine.guessTheWord("Monkey");
        gameEngine.guessTheWord("Fish");

        ArrayList<String> enteredWords = gameEngine.getEnteredWords();
        assertThat(enteredWords.containsAll(List.of("Cat", "Horse", "Monkey", "Fish"))).isTrue();
    }

    @Test
    void testEnteredWordsListIsEmptyAfterCorrectGuessedWord() {
        String wordToGuess = "Dog";
        String wordCategory = "Animal";

        gameEngine.setWordToGuess(wordToGuess, wordCategory);
        gameEngine.guessTheWord("Cat");
        gameEngine.guessTheWord("Horse");
        gameEngine.guessTheWord("Dog");

        ArrayList<String> enteredWords = gameEngine.getEnteredWords();
        assertThat(enteredWords.isEmpty()).isTrue();
    }
}