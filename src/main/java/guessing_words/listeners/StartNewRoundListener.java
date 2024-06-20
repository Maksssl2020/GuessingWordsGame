package guessing_words.listeners;

import guessing_words.gui.AdminPlayerInterface;
import guessing_words.gui.GuessingPlayerInterface;
import guessing_words.helpers.CountingDownThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartNewRoundListener implements ActionListener {
    private AdminPlayerInterface adminPlayerInterface;
    private GuessingPlayerInterface guessingPlayerInterface;
    private Runnable endGameRunnable;

    public StartNewRoundListener(AdminPlayerInterface adminPlayerInterface, GuessingPlayerInterface guessingPlayerInterface, Runnable endGameRunnable) {
        this.adminPlayerInterface = adminPlayerInterface;
        this.guessingPlayerInterface = guessingPlayerInterface;
        this.endGameRunnable = endGameRunnable;
    }

    @Override
    public void actionPerformed(ActionEvent startNewRoundEvent) {
        adminPlayerInterface.showInfoMessage("Waiting For Player Confirmation...");
        int playerChosenOption = guessingPlayerInterface.showConfirmationMessage("Do you want to start a new round?");

        if (playerChosenOption == 0) {
            adminPlayerInterface.sendMessageToPlayer("Starting New Round...");
            adminPlayerInterface.getSetWordToGuessButton().setEnabled(true);
            adminPlayerInterface.getStartNewRoundButton().setEnabled(false);

            guessingPlayerInterface.sendMessageToPlayer("Starting New Round...");
            guessingPlayerInterface.getGuessTheWordButton().setEnabled(true);
        } else {
            new CountingDownThread(
                    guessingPlayerInterface::sendMessageToPlayer,
                    adminPlayerInterface::sendMessageToPlayer,
                    endGameRunnable
            ).start();
        }
    }
}
