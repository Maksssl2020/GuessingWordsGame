package guessing_words.controller;

import guessing_words.engine.GameEngine;
import guessing_words.gui.AdminPlayerInterface;
import guessing_words.gui.GuessingPlayerInterface;
import guessing_words.helpers.Pair;
import guessing_words.listeners.GuessTheWordListener;
import guessing_words.listeners.LookAtEnteredWordsHistoryListener;
import guessing_words.listeners.SetWordToGuessListener;
import guessing_words.listeners.StartNewRoundListener;
import guessing_words.models.GamePlayer;

import java.io.IOException;
import java.util.Random;

public class GameController extends Thread {
    private GameEngine gameEngine;
    private GamePlayer adminPlayer;
    private GamePlayer guessingPlayer;
    private AdminPlayerInterface adminPlayerInterface;
    private GuessingPlayerInterface guessingPlayerInterface;

    public GameController(Pair gamePlayers) {
        gameEngine = new GameEngine();
        adminPlayerInterface = new AdminPlayerInterface();
        guessingPlayerInterface = new GuessingPlayerInterface();

        giveRoleToThePlayers(gamePlayers);
    }

    @Override
    public void run() {
        initListeners();
    }

    private void giveRoleToThePlayers(Pair gamePlayers) {
        Random drawPlayerRole = new Random();
        int drawNumber = drawPlayerRole.nextInt(2);

        if (drawNumber == 0) {
            adminPlayer = gamePlayers.getFirstPlayer();
            guessingPlayer = gamePlayers.getSecondPlayer();
        } else {
            adminPlayer = gamePlayers.getSecondPlayer();
            guessingPlayer = gamePlayers.getFirstPlayer();
        }

        adminPlayer.setPlayerInterface(adminPlayerInterface);
        guessingPlayer.setPlayerInterface(guessingPlayerInterface);
    }

    private void initListeners() {
        guessingPlayerInterface.getGuessTheWordButton().addActionListener(new GuessTheWordListener(gameEngine, adminPlayerInterface, guessingPlayerInterface));
        guessingPlayerInterface.getLookAtYourEnteredWordsHistoryButton().addActionListener(new LookAtEnteredWordsHistoryListener(gameEngine, guessingPlayerInterface));

        adminPlayerInterface.getSetWordToGuessButton().addActionListener(new SetWordToGuessListener(gameEngine, adminPlayerInterface, guessingPlayerInterface));
        adminPlayerInterface.getStartNewRoundButton().addActionListener(new StartNewRoundListener(adminPlayerInterface, guessingPlayerInterface, this::endGame));
        adminPlayerInterface.getLookAtPlayerEnteredWordsButton().addActionListener(new LookAtEnteredWordsHistoryListener(gameEngine, adminPlayerInterface));
    }

    public void endGame() {
        adminPlayerInterface.dispose();
        guessingPlayerInterface.dispose();

        try {
            adminPlayer.getPlayerSocket().close();
            guessingPlayer.getPlayerSocket().close();
            this.interrupt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
