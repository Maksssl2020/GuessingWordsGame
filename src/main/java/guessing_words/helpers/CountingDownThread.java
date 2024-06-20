package guessing_words.helpers;

import java.util.function.Consumer;

public class CountingDownThread extends Thread {
    private Consumer<String> sendMessageToGuessingPlayer;
    private Consumer<String> sendMessageToAdminPlayer;
    private Runnable endGameRunnable;

    public CountingDownThread(Consumer<String> sendMessageToGuessingPlayer, Consumer<String> sendMessageToAdminPlayer, Runnable endGameRunnable) {
        this.sendMessageToGuessingPlayer = sendMessageToGuessingPlayer;
        this.sendMessageToAdminPlayer = sendMessageToAdminPlayer;
        this.endGameRunnable = endGameRunnable;
    }

    @Override
    public void run() {
        for (int i = 3; i >= 0; i--) {
            try {
                String countingDownMessage = String.format("Game will ends for %d...", i);
                sendMessageToGuessingPlayer.accept(countingDownMessage);
                sendMessageToAdminPlayer.accept(countingDownMessage);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        endGameRunnable.run();
        this.interrupt();
    }
}
