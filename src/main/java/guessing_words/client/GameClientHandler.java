package guessing_words.client;

import guessing_words.models.GamePlayer;

public class GameClientHandler extends Thread {
    private GamePlayer gamePlayer;

    public GameClientHandler(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void run() {
        String gameMessage;
        do {
            gameMessage = gamePlayer.getPlayerInterface().getGameMessagesField().getText();
            gamePlayer.getPlayerOutput().println(gameMessage);
        } while (!gameMessage.contains("Game will ends for 0..."));
    }
}
