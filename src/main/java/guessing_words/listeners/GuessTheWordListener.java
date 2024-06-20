package guessing_words.listeners;

import guessing_words.engine.GameEngine;
import guessing_words.gui.AdminPlayerInterface;
import guessing_words.gui.GuessingPlayerInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheWordListener implements ActionListener {
    private GameEngine gameEngine;
    private AdminPlayerInterface adminPlayerInterface;
    private GuessingPlayerInterface guessingPlayerInterface;

    public GuessTheWordListener(GameEngine gameEngine, AdminPlayerInterface adminPlayerInterface, GuessingPlayerInterface guessingPlayerInterface) {
        this.gameEngine = gameEngine;
        this.adminPlayerInterface = adminPlayerInterface;
        this.guessingPlayerInterface = guessingPlayerInterface;
    }

    @Override
    public void actionPerformed(ActionEvent guessTheWordEvent) {
        String guessedWord = guessingPlayerInterface.getGuessTheWordField().getText();
        String guessingResult = gameEngine.guessTheWord(guessedWord);

        performActionDependsOnGuessingResult(guessingResult, guessedWord);
    }

    private void performActionDependsOnGuessingResult(String guessingResult, String guessedWord) {
        if (guessingResult.equals("Player guessed the hidden word!")) {
            guessingPlayerInterface.getWordToGuessField().setText(guessedWord.toUpperCase());
            guessingPlayerInterface.sendMessageToPlayer("Congratulations! You guessed the hidden word!");
            guessingPlayerInterface.getGuessTheWordButton().setEnabled(false);

            adminPlayerInterface.sendMessageToPlayer("Player, guessed the word!");
            adminPlayerInterface.getStartNewRoundButton().setEnabled(true);
        } else {
            guessingPlayerInterface.sendMessageToPlayer("Sorry, you entered a wrong word!");
            adminPlayerInterface.sendMessageToPlayer("Player, didn't guess the word!");
        }
    }
}
