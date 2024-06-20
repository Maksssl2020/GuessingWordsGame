package guessing_words.listeners;

import guessing_words.engine.GameEngine;
import guessing_words.gui.EnteredWordsByPlayerWindow;
import guessing_words.gui.GameInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LookAtEnteredWordsHistoryListener implements ActionListener {
    private GameEngine gameEngine;
    private GameInterface gameInterface;

    public LookAtEnteredWordsHistoryListener(GameEngine gameEngine, GameInterface gameInterface) {
        this.gameEngine = gameEngine;
        this.gameInterface = gameInterface;
    }

    @Override
    public void actionPerformed(ActionEvent lookAtEnteredWordHistoryEvent) {
        ArrayList<String> enteredWords = gameEngine.getEnteredWords();

        if (enteredWords.isEmpty()) {
            gameInterface.sendMessageToPlayer("Sorry, but there aren't no entered words yet!");
        } else {
            EnteredWordsByPlayerWindow enteredWordsByPlayerWindow = new EnteredWordsByPlayerWindow(gameInterface);
            enteredWordsByPlayerWindow.showEnteredWords(enteredWords);
            enteredWordsByPlayerWindow.setVisible(true);
        }
    }
}
