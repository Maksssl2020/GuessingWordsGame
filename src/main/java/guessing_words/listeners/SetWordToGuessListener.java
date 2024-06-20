package guessing_words.listeners;

import guessing_words.engine.GameEngine;
import guessing_words.gui.AdminPlayerInterface;
import guessing_words.gui.GuessingPlayerInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetWordToGuessListener implements ActionListener {
    private GameEngine gameEngine;
    private AdminPlayerInterface adminPlayerInterface;
    private GuessingPlayerInterface guessingPlayerInterface;

    public SetWordToGuessListener(GameEngine gameEngine, AdminPlayerInterface adminPlayerInterface , GuessingPlayerInterface guessingPlayerInterface) {
        this.adminPlayerInterface = adminPlayerInterface;
        this.gameEngine = gameEngine;
        this.guessingPlayerInterface = guessingPlayerInterface;
    }

    @Override
    public void actionPerformed(ActionEvent setWordToGuessEvent) {
        String wordToSet = adminPlayerInterface.getSetWordToGuessField().getText();
        String wordCategory = adminPlayerInterface.getSetWordToGuessCategoryField().getText();

        if (wordToSet.isEmpty() || wordCategory.isEmpty()) {
            adminPlayerInterface.sendMessageToPlayer("Sorry, but you can't set an empty word or empty word category!");
        } else {
            gameEngine.setWordToGuess(wordToSet, wordCategory);

            adminPlayerInterface.sendMessageToPlayer("You set a new word to guess!");
            adminPlayerInterface.getWordToGuessField().setText(wordToSet);
            adminPlayerInterface.getWordToGuessCategoryField().setText(wordCategory);
            adminPlayerInterface.getSetWordToGuessButton().setEnabled(false);

            guessingPlayerInterface.sendMessageToPlayer("New word to guess has been set!");
            guessingPlayerInterface.getWordToGuessField().setText(gameEngine.getHiddenEnteredWord());
            guessingPlayerInterface.getWordToGuessCategoryField().setText(wordCategory);
            guessingPlayerInterface.getGuessTheWordButton().setEnabled(true);
        }
    }
}
